package com.user.controller;

import com.base.entity.Result;
import com.base.utils.ResultUtils;
import com.user.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import role.IRoleController;
import role.entity.RoleEntity;

@RestController
@RequestMapping("/role")
@Api("角色接口")
public class RoleController implements IRoleController {

    @Autowired
    private RoleService service;

    @Override
    @PostMapping("/")
    public Result add(RoleEntity roleEntity) {
        service.add(roleEntity);
        return ResultUtils.Success();
    }

    @Override
    @GetMapping("/{id}")
    public Result query(String id) {
        return ResultUtils.Success(service.queryById(id));
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
