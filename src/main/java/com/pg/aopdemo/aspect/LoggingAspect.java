package com.pg.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(public int *.*.aopdemo.service.MyServiceImpl.*(..))")
    public void logBeforeMethodExecutionPointCut(){
    }

    @Before("logBeforeMethodExecutionPointCut()")
    public void logBeforeMethodExecution(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        log.info("Executing "+methodName+" with "+args.length+" arguments "+ Arrays.toString(args));
    }

    @AfterThrowing("execution(public int com.pg.aopdemo.service.MyServiceImpl.getException() throws com.pg.aopdemo.exception.PGException)")
    public void logAfterThrowingException(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("getting exception for "+methodName);
    }
    @Before("execution(public * com.pg.aopdemo.controller.*.*())")
    public void logBeforeController(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("Starting "+methodName);
    }

    @AfterReturning("execution(public * com.pg.aopdemo.controller.MyAppController.getHomePage())")
    public void logAfterController(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("Ending "+methodName);
    }

    @Before("within(com.pg.aopdemo.*.*)")
    public void logWithinPackage(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        String packageName = joinPoint.getSourceLocation().getWithinType().getPackage().getName();
        log.info("before method "+methodName+" within package "+packageName);
    }

    @Before("bean(pgservice)")
    public void logBeforeBean(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("before Bean method "+methodName);
    }

    @Before("this(com.pg.aopdemo.service.MyServiceIntf)")
    public void logBeforeMethodOfClassInstance(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("before method "+methodName+" under instance of class MyServiceIntf");
    }

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void logBeforeAnnotation(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("before method "+methodName+" having annotation @GetMapping");
    }

    @Before("this(com.pg.aopdemo.service.MyServiceIntf) && !execution(public int com.pg.aopdemo.service.MyServiceImpl.getSum(int,int))")
    public void andOrNotOperatorDemo(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        log.info(" andOrNotOperatorDemo, before method "+methodName);
    }
}
