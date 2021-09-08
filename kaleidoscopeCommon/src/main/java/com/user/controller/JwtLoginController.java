package com.user.controller;

import com.base.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import login.entity.LoginBO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(description = "登录相关接口")
public class JwtLoginController {

    @PostMapping("/login")
    @ApiOperation(value = "jwt登录接口")
    public void login(LoginBO bo){

    }
}
