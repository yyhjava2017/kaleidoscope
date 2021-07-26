package com.user.icontroller;

import com.common.entity.Result;
import com.user.entity.UserEntity;

/**
 * @zz yyh
 * @time 2020-07
 */
public interface IUserController {
    Result regist(UserEntity userEntity);
    Result query(UserEntity userEntity);
    Result delete(String id);
    Result update(UserEntity userEntity);
}
