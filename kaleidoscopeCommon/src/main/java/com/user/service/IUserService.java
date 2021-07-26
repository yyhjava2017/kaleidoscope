package com.user.service;

import com.base.entity.Result;
import user.entity.UserEntity;


/**
 * @zz yyh
 * @time 2020-07
 */
public interface IUserService{

    Result regist(UserEntity userEntity);

    Result query(UserEntity userEntity);

    Result delete(String id);

    Result update(UserEntity userEntity);
}
