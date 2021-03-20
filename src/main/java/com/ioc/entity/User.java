package com.ioc.entity;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/14
 */

public class User {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }


    public  void initUser(){
        System.out.println("...initUser");
    }

    public  void destroyUser(){
        System.out.println("...destroyUser");
    }
}
