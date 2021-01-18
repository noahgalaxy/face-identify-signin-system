package com.fisheep.utils;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
public class TestFileUtils {

    @Test
    public void testGetBase64String() throws IOException {
        String filePath = "/home/fisheep/Desktop/faceImageLib/宋运辉_gaitubao_256x300.jpg";
        File file = new File(filePath);
        if(!file.exists()){
            throw new FileNotFoundException();
        }
        FileInputStream fis = new FileInputStream(file);
        String base64String = FileUtils.getBase64String(fis);
        System.out.println(base64String.length());

    }
}
