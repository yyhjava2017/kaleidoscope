package com.kd.controller;

import com.kd.feign.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fd")
public class TestController {

    @Autowired
    private UserService service;

    @RequestMapping("/test")
    public String test() throws InterruptedException {
        String hello = service.test();
        return hello;
    }

    @RequestMapping("/sleep")
    public String sleep() throws InterruptedException {
        String hello = service.testsleep();
        return hello;
    }
}
