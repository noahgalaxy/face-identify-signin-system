package com.fisheep.exception;

public class SignFaildException extends RuntimeException{
    public SignFaildException(){
        super();
    }
    public SignFaildException(String message){
        super(message);
    }
}
