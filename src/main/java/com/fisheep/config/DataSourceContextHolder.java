package com.fisheep.config;

public class DataSourceContextHolder {
    private static ThreadLocal<String> dsContextHolder = new ThreadLocal<>();

    public static void setDs(String dsName){
        dsContextHolder.set(dsName);
    }

    public static String getDs(){
        return dsContextHolder.get();
    }

    public static void clear(){
        dsContextHolder.remove();
    }
}
