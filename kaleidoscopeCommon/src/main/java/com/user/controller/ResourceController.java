package com.user.controller;

import com.base.entity.Result;
import com.base.utils.ResultUtils;
import com.user.service.ResourceService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource.IResourceController;
import resource.entity.ResourceEntity;

import javax.annotation.Resource;

@RestController
@RequestMapping("/res")
@Api("权限资源接口")
public class ResourceController implements IResourceController {

    @Resource
    private ResourceService service;

    @PostMapping("/")
    @Override
    public Result add(ResourceEntity entity) {
        service.add(entity);
        return ResultUtils.Success();
    }

    @Override
    public Result query(String id) {
        return null;
    }

    @Override
    public Result delete(String id) {
        return null;
    }

    @Override
    public Result update(ResourceEntity entity) {
        return null;
    }
}
