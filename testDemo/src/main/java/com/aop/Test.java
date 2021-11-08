package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.Assert;

@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(SpringConfigtion.class);
        ac.refresh();
        Assert.state(2==2,"DEEEEEE");
        MyCaculator myCaculator = ac.getBean(MyCaculator.class);
        System.out.println(myCaculator.add());
    }
}
