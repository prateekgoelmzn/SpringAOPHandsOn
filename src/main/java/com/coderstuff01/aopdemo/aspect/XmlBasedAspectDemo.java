package com.coderstuff01.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlBasedAspectDemo {

    Logger log = LoggerFactory.getLogger(this.getClass());
    public void logAfterThrowingException(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("XmlBasedAspectDemo , getting exception for "+methodName);
    }
}
