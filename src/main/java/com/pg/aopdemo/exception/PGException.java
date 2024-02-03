package com.pg.aopdemo.exception;

public class PGException extends Exception{

    public PGException(){
        super();
    }

    public PGException(String msg){
        super(msg);
    }

    public PGException(String msg , Throwable throwable){
        super(msg, throwable);
    }
}
