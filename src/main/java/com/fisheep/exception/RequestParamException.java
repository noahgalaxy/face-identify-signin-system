package com.fisheep.exception;

public class RequestParamException extends RuntimeException {
    public RequestParamException(){
        super();
    }
    public RequestParamException(String exceptionMsg){
        super(exceptionMsg);
    }
}
