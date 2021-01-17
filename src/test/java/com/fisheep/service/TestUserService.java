package com.fisheep.service;

import com.fisheep.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserService {
    @Autowired
    UserService userService;

    @Test
    public void getUser(){
        String faceImgPath = "/home/fisheep/Desktop/faceImageLib/8094029A35BC2F825A72B58E73FA81A9.png";
        User user = userService.getUser(faceImgPath);
        System.out.println(user);
    }
}
