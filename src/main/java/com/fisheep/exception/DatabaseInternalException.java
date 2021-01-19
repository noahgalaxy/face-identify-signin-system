package com.fisheep.exception;

public class DatabaseInternalException extends RuntimeException{
    public DatabaseInternalException(){
        super();
    }
    public DatabaseInternalException(String message){
        super(message);
    }
}
