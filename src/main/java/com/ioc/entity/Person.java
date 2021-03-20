package com.ioc.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/16
 */
public class Person {

    @Value("测试Person")
    private  String name;

    private  String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
