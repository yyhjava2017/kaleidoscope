package com.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@Ttest(age = 18)
public class Test {
    @Ttest(name = {"yhsd","ahduihf"})
    public void hello(){
        System.out.println("hjkjsfsd");
    }

    public static void main(String[] args) throws ClassNotFoundException {

        Class c3 = People.AUTUMN.getClass();
        People[] ps = People.values();
        Arrays.stream(ps).forEach(o->{
            System.out.println(o.name());
        });
    }
}

enum People {
    SPRING{
        @Override
        public void say() {
            System.out.println("我是春天");
        }
    },SUMMER{
        @Override
        public void say() {
            System.out.println("我是夏天");
        }
    },AUTUMN{
        @Override
        public void say() {
            System.out.println("我是秋天");
        }
    },WINTER{
        @Override
        public void say() {
            System.out.println("我是冬天");
        }
    };
    public abstract void say();
}


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Ttest {
    String[] name() default "yacasu";
    int age() default 0;
}