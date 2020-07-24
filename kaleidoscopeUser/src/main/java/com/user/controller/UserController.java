package com.user.controller;
import com.common.entity.Result;
import com.common.entity.StatusCode;
import com.user.entity.UserEntity;
import com.user.icontroller.IUserController;
import com.user.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @zz yyh
 * @time 2020-07
 */
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
    @Autowired
    private IUserService userService;

    @Override
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @Override
    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public Result regist(@RequestBody UserEntity userEntity) {
        return userService.regist(userEntity);
    }

    @Override
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public Result query(UserEntity userEntity) {
        return userService.query(userEntity);
    }


}
