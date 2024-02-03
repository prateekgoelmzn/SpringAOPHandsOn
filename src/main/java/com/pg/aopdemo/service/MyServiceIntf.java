package com.coderstuff01.aopdemo.service;

import com.coderstuff01.aopdemo.exception.CoderStuffException;

public interface MyServiceIntf {
    public int getSum(int a, int b);
    public int multiply(int a, int b);
    public int getException() throws CoderStuffException;
}
