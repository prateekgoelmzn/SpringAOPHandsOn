package com.pg.aopdemo.controller;

import com.pg.aopdemo.exception.PGException;
import com.pg.aopdemo.service.MyServiceIntf;
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
        catch (PGException exp){
            log.error(exp.getMessage());
        }
        return ResponseEntity.ok("Hello World! sum is "+sum+" and multiply is "+multiply);
    }
}
