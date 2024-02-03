package com.coderstuff01.aopdemo.exception;

public class CoderStuffException extends Exception{

    public CoderStuffException(){
        super();
    }

    public CoderStuffException(String msg){
        super(msg);
    }

    public CoderStuffException(String msg , Throwable throwable){
        super(msg, throwable);
    }
}
