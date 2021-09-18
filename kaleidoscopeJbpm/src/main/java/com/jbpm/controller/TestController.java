package com.jbpm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/config")
    public String getConfigInfo(){
        return "success:  "+configInfo;
    }
}
