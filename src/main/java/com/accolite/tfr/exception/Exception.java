package com.accolite.tfr.exception;

public class Exception extends RuntimeException{
    private static final long serviceVersionUID = 1L;

    public Exception(String message){
        super(message);
    }

    public Exception(String message, Throwable throwable) {
        super(message, throwable);
    }
}