package com.fisheep.others;


import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MultiThreadReadOneStream {

    private class ThreadReadOne implements Runnable{
        byte[] bytes;

        public ThreadReadOne(byte[] bytes) {
            this.bytes = bytes;
        }

        @Override
        public void run() {
            int i;
            for( i = 0; i < this.bytes.length; i += 4096){
                System.out.println(Thread.currentThread().getName()+"读取了："+4096);
            }
            System.out.println(Thread.currentThread().getName()+"读取了："+(this.bytes.length - i+4096));
        }
    }

    private class ThreadReadTwo implements Runnable{
        InputStream is;

        public ThreadReadTwo(InputStream is) {
            this.is = is;
        }
        @Override
        public void run() {
            BufferedInputStream bis = new BufferedInputStream(this.is);
            byte[] buffer = new byte[4096];
            int len = -1;
            while (true){
                try {
                    if ((len = bis.read(buffer))!=-1){
                        System.out.println(Thread.currentThread().getName()+"读取了"+len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test1(){
        String filePath = "/home/fisheep/Desktop/faceImageLib/宋运辉_gaitubao_256x300.jpg";
        File file = new File(filePath);
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] buffer = new byte[4096];
            int len = -1;
            while ((len = bis.read(buffer)) != -1){
                System.out.println("main线程读取了并写到了字节数组输出流："+len);
                baos.write(buffer, 0, len);
            }
            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            System.out.println("===============");
//            while ((len = bais.read(buffer)) != -1){
//                System.out.println("2222main线程读取了字节数组："+len);
//            }
            Thread thread1 = new Thread(new ThreadReadOne(bytes));
            Thread thread2 = new Thread(new ThreadReadTwo(bais));
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println("end: bytes.length: "+ bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
