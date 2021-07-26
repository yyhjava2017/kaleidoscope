package com.user.controller;

import com.base.entity.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import role.IRoleController;
import role.entity.RoleEntity;

@RestController
@RequestMapping("/role")
@Api("角色接口")
public class RoleController implements IRoleController {

    @Override
    @PostMapping("/")
    public Result add(RoleEntity roleEntity) {
        return null;
    }

    @Override
    public Result query(RoleEntity roleEntity) {
        return null;
    }

    @Override
    public Result delete(String id) {
        return null;
    }

    @Override
    public Result update(RoleEntity roleEntity) {
        return null;
    }


}
