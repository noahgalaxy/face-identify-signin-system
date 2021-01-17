package com.fisheep.controller;

import com.fisheep.constant.HttpStatus;
import com.fisheep.domain.User;
import com.fisheep.exception.RequestParamException;
import com.fisheep.service.SignInService;
import com.fisheep.service.UserService;
import com.fisheep.utils.RestfulResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("signIn")
public class SignInController {

    @Autowired
    UserService userService;

    @Autowired
    SignInService signInService;

    private Logger logger = LoggerFactory.getLogger(SignInController.class);

    @PostMapping(value = "/face")
    public RestfulResult faceSignIn(@RequestBody MultipartFile file){
        if(file.isEmpty()){
            throw new RequestParamException();
        }
        String originalFilename = file.getOriginalFilename();
        String fileName = file.getName();
        logger.info(String.format("faceSignIn接口得到上传人脸图片，originalFilename:【%s】，fileName：【%s】", originalFilename, fileName));
        User user = signInService.faceSignIn(file);
        return new RestfulResult.Builder(HttpStatus.SUCCESS)
                .setMsg("人脸签到成功")
                .build();
    }
    @PostMapping(value = "/facePath")
    public RestfulResult faceImgPathSignIn(@RequestBody String faceImgPath){
        logger.info(String.format("faceImgPathSignIn接口得到人脸图片路径【%s】", faceImgPath));
        if(faceImgPath == null || faceImgPath.length() == 0){
            throw new RequestParamException();
        }
        User user = userService.getUser(faceImgPath);
        return new RestfulResult.Builder(HttpStatus.SUCCESS)
                .setMsg("人脸路径签到成功")
                .setData(user)
                .build();
    }
}
