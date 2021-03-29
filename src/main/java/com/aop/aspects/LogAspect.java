package com.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/22
 */
@Component
@Aspect
public class LogAspect {


    @Pointcut("execution(* com.aop.service.impl.*.*(..))")
    public  void pointcut(){
    }

    @Before("pointcut()")
    //@Before("@annotation(com.aop.util.LoggerOut)")
    public  void before(JoinPoint joinPoint){
        String Methodname = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知,方法名字:"+Methodname+",参数："+ Arrays.asList(args));
    }

    @After("pointcut()")
    public  void after(){
        System.out.println("后置通知");
    }

    @AfterReturning(value = "pointcut()", returning="returnValue")
    public  void AfterReturning(Object returnValue){
        if(null!=returnValue){
            System.out.println("后置返回通知"+returnValue.toString());
        }else{
            System.out.println("后置返回通知");
        }

    }

    @AfterThrowing(value = "pointcut()",throwing="ex")
    public  void AfterThrowing(Exception ex){
        StringWriter stirngWriter =new StringWriter();
        ex.printStackTrace(new PrintWriter(stirngWriter,true));
        System.out.println("后置异常通知"+stirngWriter.getBuffer().toString());
    }

    @Around("pointcut()")
    public  void Around(ProceedingJoinPoint proceedingJoinPoint){
        String Methodname = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = "";
        //手动执行方法
        try {
            System.out.println("环绕，前置通知,方法名字:"+Methodname+",参数："+ Arrays.asList(args));
            result= proceedingJoinPoint.proceed();
            System.out.println("环绕，后置通知"+result);
        } catch (Throwable throwable) {
            System.out.println("环绕，异常返回通知"+throwable.toString());
            throwable.printStackTrace();
        }finally {
            System.out.println("环绕，后置返回通知"+result);
        }

    }
}
