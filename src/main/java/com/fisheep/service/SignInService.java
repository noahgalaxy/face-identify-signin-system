package com.fisheep.service;

import com.fisheep.config.ChooseDataSource;
import com.fisheep.constant.DataSourceConstants;
import com.fisheep.dao.SignInDao;
import com.fisheep.dao.UserDao;
import com.fisheep.dao.openlookeng.OpenlookengSignInDao;
import com.fisheep.domain.User;
import com.fisheep.exception.NoUserException;
import com.fisheep.utils.DateUtils;
import com.fisheep.utils.FileUtils;
import io.prestosql.jdbc.$internal.okhttp3.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Service
public class SignInService {
    /*
    - 这里不注入自己的话，后面的faceSignIn方法里面，开两个线程道不同数据源里面去进行查询的时候，
        会导致aop切面失效，也就是@ChooseDatasource这个注解会失效，解决办法就是在这里注入自己。
        遇到的循环依赖spring会自己解决；
     */
    @Autowired
    SignInService signInService;

    Logger logger = LoggerFactory.getLogger(SignInService.class);

    @Value("${face-image-root-dir}")
    String faceImageRootDir;

    @Autowired
    SignInDao signInDao;

    @Autowired
    OpenlookengSignInDao openlookengSignInDao;

    @ChooseDataSource(DataSourceConstants.DEFAULT_DATA_SOURCE)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        int[] currYearMonthDay = DateUtils.getCurrYearMonthDay();
        String year = String.valueOf(currYearMonthDay[0]);
        String month = String.valueOf(currYearMonthDay[1]);
        String day = String.valueOf(currYearMonthDay[2]);
        String systemSeperator = File.separator;
        logger.info("当前线程："+Thread.currentThread().getName()+": 系统文件路径分隔符："+systemSeperator);
        StringBuilder filePathSb = new StringBuilder();
        //构建文件存放路径
        filePathSb.append(faceImageRootDir)
                .append(systemSeperator)
                .append(year)
                .append(systemSeperator)
                .append(month)
                .append(systemSeperator)
                .append(day)
                .append(systemSeperator)
                .append(originalFilename);

        String filePath = filePathSb.toString();

        File outputFile = new File(filePath);
        File parentFile = outputFile.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        if(!outputFile.exists()){
            logger.info(filePath + ": 文件不存在，执行新建");
            outputFile.createNewFile();
        }

        //包装为缓冲流
        FileOutputStream fos = new FileOutputStream(outputFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = file.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        //写入outputfile
        byte[] buff = new byte[1024];
        while (bis.read(buff) != -1){
            fos.write(buff);
        }
        //清空内存中的缓冲区，刷到输出文件中；
        fos.flush();
        fos.close();
        is.close();
        signInDao.insertFaceImageToAllFaceImageFileTable(filePath);
        return filePath;
    }

    /*
    - 转为base64编码，openlookeng的face_scan 函数接受路径或者base64编码之后的
     */
    @ChooseDataSource(DataSourceConstants.OPENLOOKEENG_DATA_SOURCE)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User getUserFromOpenlookeng(MultipartFile file) throws IOException {
        byte[] fileBytes = file.getBytes();
        String base64String = FileUtils.getBase64String(fileBytes);
        logger.info("当前线程："+Thread.currentThread().getName()+"：base64String长度为： "+base64String.length());
        User user = openlookengSignInDao.getUserFromOpenlookeng(base64String);
        return user;
    }

    /*
    内部类，多线程callable执行保存文件任务
     */
    public class SaveFileTask implements Callable<String>{
        MultipartFile file;
        public SaveFileTask() {
        }
        public SaveFileTask(MultipartFile file) {
            this.file = file;
        }

        @Override
        public String call() throws Exception {
            //执行保存文件，然后将文件放到数据库里面
            String filePath = signInService.saveFile(this.file);
            return filePath;
        }
    }
    /*
    内部类，多线程执行到openlookeng查询人脸照片任务
     */
    public class OpenLookengGetUserNoTask implements Callable<User>{

        MultipartFile file;
        public OpenLookengGetUserNoTask(){
        }
        public OpenLookengGetUserNoTask(MultipartFile file){
            this.file = file;
        }
        @Override
        public User call() throws Exception {
            //执行openlookeng侧查询，将查询到的userNo返回
            User user = signInService.getUserFromOpenlookeng(this.file);
            return user;
        }
    }

    public User faceSignIn(MultipartFile file) throws NoUserException {
    /*
        - A线程，保存文件，将文件路径保存到数据表中；
        - B线程，向openlookeng里面查询该人脸图像的userNo，并返回userNo
        - 然后主线程，等待他们两个完成，等待B现成的userNo，以及A现成的文件路径；
            在A、B线程都执行成功并且userNo不为空、以及文件保存成功的时候，将这个人的签到记录保存到签到表中；
     */

        SaveFileTask saveFileTask = new SaveFileTask(file);
        FutureTask<String> saveFileFuture = new FutureTask<>(saveFileTask);

        OpenLookengGetUserNoTask openLookengGetUserNoTask = new OpenLookengGetUserNoTask(file);
        FutureTask<User> openlookengFutureTask = new FutureTask<>(openLookengGetUserNoTask);

        Thread saveFileThread = new Thread(saveFileFuture);
        Thread openlookengThread = new Thread(openlookengFutureTask);


        saveFileThread.start();
        openlookengThread.start();

//        保存异步任务执行结果
        String filePath = null;
        User user = null;
        try {
            filePath = saveFileFuture.get();
            user = openlookengFutureTask.get();
            saveFileThread.join();
            openlookengThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
//            确保执行结果成功
            if(filePath == null || user == null || user.getUserNo() == null){
                throw new NoUserException();
            }
        }
        logger.info(String.format("文件保存路径%s", filePath));
        return user;
    }
}
