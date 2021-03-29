package com.aop.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/28
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerOut {
    public  String name() default "";
}
