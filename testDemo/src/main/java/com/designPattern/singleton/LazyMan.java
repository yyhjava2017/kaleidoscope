package com.designPattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉式 ==>（DCL懒汉式）
 * 1原始得懒汉式不安全，因为new的过程非原子性的，所以有可能返回null
 */
public class LazyMan {


    /**
     * 加上volatile禁止指令重排序
     * new 的过程包括：
     * 1、分配内存空间 2、执行构造方法，初始化对象 3、把这个对象指向分配的空间
     * 这三步在cpu内部可以允许指令重排序，但对于单例模式，可能导致返回的对象没有完成
     */
    private volatile static LazyMan lazyMan;

    private LazyMan(){

    }

    public static LazyMan getInstance(){

            if(lazyMan==null){
                synchronized (LazyMan.class) {
                    if(lazyMan==null) {
                        lazyMan = new LazyMan();
                    }
                }
            }

        return lazyMan;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(LazyMan.getInstance());
            }).start();
        }

        TimeUnit.SECONDS.sleep(20);
    }
}
