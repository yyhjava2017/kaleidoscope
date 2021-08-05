package com.user.service;

import role.entity.RoleEntity;

public interface RoleService {

    void add(RoleEntity roleEntity);

    Object queryById(String id);
}
