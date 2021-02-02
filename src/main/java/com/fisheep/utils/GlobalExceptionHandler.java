package com.fisheep.utils;

import com.fisheep.constant.HttpStatus;
import com.fisheep.exception.RequestParamException;
import com.fisheep.exception.SignFaildException;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestParamException.class)
    public RestfulResult requestParamsExceptionHandler(){
        return new RestfulResult.Builder(HttpStatus.BAD_REQUEST)
                .setMsg("请求参数异常")
                .build();
    }
    @ExceptionHandler(NoSuchMethodException.class)
    public RestfulResult noUserExceptionHandler(){
        return new RestfulResult.Builder(HttpStatus.SUCCESS)
                .setMsg("查询用户不存在")
                .build();
    }

    @ExceptionHandler(SignFaildException.class)
    public RestfulResult signFaildExceptionHandler(){
        return new RestfulResult.Builder(HttpStatus.SUCCESS)
                .setMsg("签到失败，请重试")
                .build();
    }
}
