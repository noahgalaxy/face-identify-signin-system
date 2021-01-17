package com.fisheep.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSignInDao {

    @Autowired
    SignInDao signInDao;

    @Test
    public void insertFaceImageToAllFaceImageFileTable(){
        String filePath = "/home/fisheep/Desktop/FaceImageLib/tmp.jpg";
        signInDao.insertFaceImageToAllFaceImageFileTable(filePath);
    }
}
