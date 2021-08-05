package com.user.service.impl;

import com.user.dao.ResourceMapper;
import com.user.service.ResourceService;
import org.springframework.stereotype.Service;
import resource.entity.ResourceEntity;
import role.entity.RoleEntity;

import javax.annotation.Resource;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Resource
    private ResourceMapper mapper;

    @Override
    public void add(ResourceEntity roleEntity) {
        mapper.insert(roleEntity);
    }
}
