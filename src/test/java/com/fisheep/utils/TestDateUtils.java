package com.fisheep.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDateUtils {

    @Value("${face-image-root-dir}")
    String rootDir;

    @Test
    public void getCurrYearMonthDay(){
        int[] currYearMonthDay = DateUtils.getCurrYearMonthDay();
        for (int i = 0; i < currYearMonthDay.length; i++) {
            System.out.println(currYearMonthDay[i]);
        }
        System.out.println(rootDir);
    }
}
