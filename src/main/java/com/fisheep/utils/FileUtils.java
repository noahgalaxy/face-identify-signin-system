package com.fisheep.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class FileUtils {
    public static byte[] getByteArrayFromInputStream(InputStream io) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedInputStream bis = new BufferedInputStream(io);
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = bis.read(buffer))!= -1){
            baos.write(buffer, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    public static String getBase64String(InputStream io) throws IOException {
        byte[] bytes = getByteArrayFromInputStream(io);
        String base64String = getBase64String(bytes);
        return base64String;
    }
    public static String getBase64String(byte[] fileBytes) throws IOException {
        String base64String = Base64.getEncoder().encodeToString(fileBytes);
        return base64String;
    }
}
