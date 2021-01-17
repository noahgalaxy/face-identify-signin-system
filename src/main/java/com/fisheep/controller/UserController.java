package com.fisheep.controller;

import com.fisheep.constant.HttpStatus;
import com.fisheep.service.UserService;
import com.fisheep.utils.RestfulResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/users")
    public RestfulResult userSignIn(String faceImgBase64String) {
        System.out.println("/users 接收到了faceImgBase64String： "+faceImgBase64String);
        String userId = userService.getUserId(faceImgBase64String);
        return new RestfulResult.Builder(HttpStatus.SUCCESS)
                .setMsg("查询成功")
                .setData(userId)
                .build();
    }

    @PostMapping(path = "/allUserNames")
    public RestfulResult getAllUserNames() {
        System.out.println("执行getAllUserNames");
        List<String> allUserNames = userService.getAllUserNames();

        return new RestfulResult.Builder(HttpStatus.SUCCESS)
                .setData(allUserNames)
                .setMsg("查询成功")
                .build();
    }


    @PostMapping(path = "/users1")
    public String userSignIn1(String faceImgBase64String) {
        System.out.println("/users 接收到了faceImgBase64String： "+faceImgBase64String);
        return userService.getUserId1(faceImgBase64String);
    }
}
