package com.aop;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/21
 */
public class Calculator implements  Icalculator {

    @Override
    public Integer add(int i, int j) {
        return i+j;
    }
}
