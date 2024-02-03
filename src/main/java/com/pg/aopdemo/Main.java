package com.pg.aopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAspectJAutoProxy
@ImportResource("classpath:spring-aop-custom.xml")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}