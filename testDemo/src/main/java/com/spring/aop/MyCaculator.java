package com.spring.aop;

public class MyCaculator {
    private int result = 0;
    public int add(){
        System.out.println("计算加法！");
        return ++result;
    }
}
