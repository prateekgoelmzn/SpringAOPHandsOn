package com.coderstuff01.aopdemo.service;

import com.coderstuff01.aopdemo.exception.CoderStuffException;
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
    public int getException() throws CoderStuffException {
        throw new CoderStuffException("this is exception");
    }
}
