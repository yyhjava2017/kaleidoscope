package com.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(2020);
        System.out.println(integer.compareAndSet(2020, 2021));

        System.out.println(integer.compareAndSet(2020, 2021));
        System.out.println(integer.get());

    }
}
