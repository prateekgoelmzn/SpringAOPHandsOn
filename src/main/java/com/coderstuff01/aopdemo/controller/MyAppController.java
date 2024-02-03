package com.coderstuff01.aopdemo.controller;

import com.coderstuff01.aopdemo.aspect.LoggingAspect;
import com.coderstuff01.aopdemo.exception.CoderStuffException;
import com.coderstuff01.aopdemo.service.MyServiceIntf;
import org.aspectj.apache.bcel.classfile.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAppController {


    Logger log = LoggerFactory.getLogger(MyAppController.class);

    @Autowired
    MyServiceIntf service;

    @GetMapping("/home")
    public ResponseEntity<String> getHomePage(){
        int sum = service.getSum(4,5);
        int multiply = service.multiply(4,5);
        try{
            service.getException();
        }
        catch (CoderStuffException exp){
            log.error(exp.getMessage());
        }
        return ResponseEntity.ok("Hello World! sum is "+sum+" and multiply is "+multiply);
    }
}
