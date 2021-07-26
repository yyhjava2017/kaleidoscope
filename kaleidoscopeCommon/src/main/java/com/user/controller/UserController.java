package com.user.controller;


import com.base.entity.Result;
import com.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.entity.UserEntity;
import user.icontroller.IUserController;


/**
 * @zz yyh
 * @time 2020-07
 */
@RestController
@RequestMapping("/user")
@Api("用户接口")
public class UserController implements IUserController {
    @Autowired
    private IUserService userService;

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result query(UserEntity userEntity) {
        return userService.query(userEntity);
    }

    @Override
    @ApiOperation("根据id删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result regist(@RequestBody UserEntity userEntity) {
        return userService.regist(userEntity);
    }


    @Override
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Result update(UserEntity userEntity) {
        return userService.update(userEntity);
    }
}