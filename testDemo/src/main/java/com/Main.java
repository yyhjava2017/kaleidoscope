package com;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println(YStringUtils.isSuccess("success"));
        System.out.println(YStringUtils.isSuccess("Success"));
        YStringUtils.testList();
    }
}
