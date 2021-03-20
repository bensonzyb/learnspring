package com.ioc.entity;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/16
 */

public class Mysql {

    private String url;
    private String driver;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Mysql(){
        System.out.println("初始化MySQL");
    }

    public Mysql(Mysql mysql){
        System.out.println("初始化MySQL:"+mysql.toString());
    }
    @Override
    public String toString() {
        return "Mysql{" +
                "url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
