package com.pg.aopdemo.service;

import com.pg.aopdemo.exception.PGException;

public interface MyServiceIntf {
    public int getSum(int a, int b);
    public int multiply(int a, int b);
    public int getException() throws PGException;
}
