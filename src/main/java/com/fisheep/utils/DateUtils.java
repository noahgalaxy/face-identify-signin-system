package com.fisheep.utils;

import java.time.LocalDateTime;

public class DateUtils {
    /*
    获取当前日期的年份，月份，天
     */
    public static int[] getCurrYearMonthDay(){
        int[] yearMonthDay = new int[3];
        LocalDateTime dateTime = LocalDateTime.now();
        int year = dateTime.getYear();
        int month = dateTime.getMonth().getValue();
        int dayOfMonth = dateTime.getDayOfMonth();
        yearMonthDay[0] = year;
        yearMonthDay[1] = month;
        yearMonthDay[2] = dayOfMonth;
        return yearMonthDay;
    }
}
