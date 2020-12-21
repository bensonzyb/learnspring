package com.spring;

/**
 * @author by ben
 * @Description TODO
 * @Date 2020/12/20
 */
public @interface Scope {
    String value()  default  "singleton";
}
