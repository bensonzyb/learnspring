package com.aop.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/22
 */
@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.aop.*.*(..))")
    public  void before(){
        System.out.println("前置通知");
    }

    @After("execution(* com.aop.service.impl.*.*(..))")
    public  void after(){
        System.out.println("后置通知");
    }

    @AfterReturning("execution(* com.aop.service.impl.*.*(..))")
    public  void AfterReturning(){
        System.out.println("后置返回通知");
    }

    @AfterThrowing("execution(* com.aop.service.impl.*.*(..))")
    public  void AfterThrowing(){
        System.out.println("后置异常通知");
    }

    //@Around("execution(* com.aop.service.impl.*.*(..))")
    public  void Around(){
        System.out.println("环绕通知");
    }
}
