package com.pg.aopdemo.service;

import com.pg.aopdemo.exception.PGException;
import org.springframework.stereotype.Service;

@Service(value = "coderstuffservice")
public class MyServiceImpl  implements MyServiceIntf{
    @Override
    public int getSum(int a, int b) {
        return a+b;
    }

    @Override
    public int multiply(int a, int b){return a*b;}

    @Override
    public int getException() throws PGException {
        throw new PGException("this is exception");
    }
}
