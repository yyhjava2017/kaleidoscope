package com.user.service.impl;

import com.user.dao.RoleMapper;
import com.user.service.RoleService;
import org.springframework.stereotype.Service;
import role.entity.RoleEntity;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper mapper;

    @Override
    public void add(RoleEntity roleEntity) {
        mapper.insert(roleEntity);
    }

    @Override
    public Object queryById(String id) {
        return mapper.selectById(id);
    }
}
