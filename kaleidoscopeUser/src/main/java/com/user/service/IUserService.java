package com.user.service;

import com.common.entity.Result;
import com.user.entity.UserEntity;

/**
 * @zz yyh
 * @time 2020-07
 */
public interface IUserService{

    Result regist(UserEntity userEntity);

    Result query(UserEntity userEntity);

    Result delete(String id);
}
