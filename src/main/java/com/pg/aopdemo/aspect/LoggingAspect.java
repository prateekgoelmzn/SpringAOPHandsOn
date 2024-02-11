package com.pg.aopdemo.aspect;

import com.pg.aopdemo.exception.PGException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    @AfterThrowing(
            pointcut = "execution(public int com.pg.aopdemo.service.MyServiceImpl.getException())",
            throwing = "exception"
    )
    public void logAfterThrowingDemo(PGException exception){
        log.info("@AfterThrowing : Exception "+exception.getMessage());
    }

    @After("execution(public int com.pg.aopdemo.service.MyServiceImpl.getException())")
    public void logAfterThrowingDemo(){
        log.info("@After : After MyServiceImpl.getException()");
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

    @Before("execution(public * com.pg.aopdemo.controller.*.*())")
    public void logBeforeAdviceDemo(){
        log.info(" Before Advice Demo logging....");
    }

    @AfterReturning("execution(public * com.pg.aopdemo.controller.MyAppController.getHomePage())")
    public void logAfterController(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        String kind = joinPoint.getKind();
        log.info("Ending "+methodName+ " Kind "+kind);
    }

    @AfterReturning(
            pointcut = "execution(public int com.pg.aopdemo.service.MyServiceImpl.getSum(..))",
            returning = "retVal"
    )
    public void logAfterReturningDemo(Object retVal){
        log.info("@AfterReturning : MyServiceImpl.getSum returns "+retVal);
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

    @Around("execution(public int com.pg.aopdemo.service.MyServiceImpl.getSum(..))")
    public Object logAfterDemo1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("@Around : before method execution");
        Object returnVal = proceedingJoinPoint.proceed();
        log.info("@Around : return value "+returnVal.toString());
        log.info("@Around : after method execution");
        return returnVal;
    }

    /*
     * Below code gives null pointer exception
     * org.springframework.aop.AopInvocationException: Null return value from advice does not match primitive return type for: public int com.coderstuff01.aopdemo.service.MyServiceImpl.getSum(int,int)]
     */
//    @Around("execution(public int com.coderstuff01.aopdemo.service.MyServiceImpl.getSum(..))")
//    public void logAfterDemo2(){
//        log.info("@Around logAfterDemo2 : before method execution");
//        log.info("@Around logAfterDemo2 : after method execution");
//    }
}
