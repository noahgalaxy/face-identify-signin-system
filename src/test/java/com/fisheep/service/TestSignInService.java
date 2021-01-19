package com.fisheep.service;


import com.fisheep.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@SpringBootTest
public class TestSignInService {
    @Autowired
    SignInService signInService;

    @Test
    public void commonMethod(int i){
        System.out.println(Thread.currentThread().getName()+",commonMethod:"+i);
    }
    @Test
    public void testMultiThread() throws InterruptedException {
        class MyThread1 extends Thread{
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    try {
                        commonMethod(i);
//                        System.out.println(Thread.currentThread().getName()+" MyThread1打印i:"+i+"，进入睡眠");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        class MyThread2 extends Thread{
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    try {
                        commonMethod(i);
//                        System.out.println(Thread.currentThread().getName()+"MyThread2打印j:"+i+"，进入睡眠");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();
        System.out.println(Thread.currentThread().getName()+", 主线程打印");
    }
    @Test
    public void testFutureTask() throws InterruptedException, ExecutionException {
        class BaiduTask implements Callable<Integer>{

            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"线程进入openlookeng进行了查询");
                return 2;
            }
        }
        BaiduTask baiduTask = new BaiduTask();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(baiduTask);
        Thread thread = new Thread(integerFutureTask);
        thread.start();
        thread.join();
        Integer result = integerFutureTask.get();
        System.out.println(Thread.currentThread().getName()+"主线程等待子线程完成完成，获取子线程的返回结果："+result);
    }

    @Test
    public void testFaceSignIn() throws IOException {
        String filePath = "/home/fisheep/Desktop/faceImageLib/宋运辉_gaitubao_256x300.jpg";
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile mockMultipartFile = new MockMultipartFile("自定义名字", "测试saveFile.png","image/jpeg", fileInputStream);
        System.out.println("getOriginalFileName: "+mockMultipartFile.getOriginalFilename());
        System.out.println("getName: "+mockMultipartFile.getName());
//        User userFromOpenlookeng = signInService.getUserFromOpenlookeng(mockMultipartFile);
//        System.out.println(userFromOpenlookeng);

        User user = signInService.faceSignIn(mockMultipartFile);
        System.out.println(user);


//        String s = signInService.saveFile(mockMultipartFile);
//        System.out.println(s);
    }

}
