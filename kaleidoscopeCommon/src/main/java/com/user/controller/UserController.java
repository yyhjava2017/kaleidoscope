package com.user.controller;


import com.base.entity.Result;
import com.user.config.ServerConfig;
import com.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.*;
import user.entity.UserEntity;
import user.icontroller.IUserController;

import javax.servlet.http.HttpServletRequest;


/**
 * @zz yyh
 * @time 2020-07
 */
@RestController
@Api("用户接口")
public class UserController implements IUserController {
    @Autowired
    private ServerConfig serverConfig ;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result query(UserEntity userEntity) {
        return userService.query(userEntity);
    }

    @ApiOperation("根据id删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result regist(@RequestBody UserEntity userEntity) {
        return userService.regist(userEntity);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Result update(UserEntity userEntity) {
        return userService.update(userEntity);
    }

    @Override
    public String testsleep() throws InterruptedException {
        System.out.println("sleep");
        Thread.sleep(2000);
        return "sleep after";
    }

    @Override
    public String test() throws InterruptedException {
        System.out.println("test");
        return serverConfig.getUrl();
    }

}
