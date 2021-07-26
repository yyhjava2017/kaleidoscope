package com.user.service.impl;
import com.base.constant.TableName;
import com.base.entity.Result;
import com.base.entity.StatusCode;
import com.user.dao.UserMapper;
import com.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.entity.UserEntity;

import java.util.List;

/**
 * @zz yyh
 * @time 2020-07
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result update(UserEntity userEntity) {
        userMapper.update(userEntity);
        return new Result(StatusCode.SUCCESS,"success","更新成功",null);

    }

    @Override
    public Result regist(UserEntity userEntity){
        userMapper.save(userEntity, TableName.YINY_USER);
        return new Result(StatusCode.SUCCESS,"success","插入成功",null);
    }

    @Override
    public Result delete(String id) {
        userMapper.deleteById(id);
        return new Result(StatusCode.SUCCESS,"success","删除成功",null);
    }

    @Override
    public Result query(UserEntity userEntity) {
        List<UserEntity> list = userMapper.queryUsers(userEntity.getName());
        return new Result(StatusCode.SUCCESS,"success","查询成功",list);
    }
}
