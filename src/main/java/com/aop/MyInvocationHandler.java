package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author by ben
 * @Description  委托执行的处理类

 */
public class MyInvocationHandler implements InvocationHandler {
    //要代理的目标类
    Object target;
    public  MyInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("参数："+ Arrays.asList(args));
        Object result =method.invoke(target,args);
        return result;
    }
}
