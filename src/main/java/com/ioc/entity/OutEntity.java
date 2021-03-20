package com.ioc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/16
 */
@Component
public class OutEntity {

    @Value("外部bean的注入")
    private  String outName;

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }
}
