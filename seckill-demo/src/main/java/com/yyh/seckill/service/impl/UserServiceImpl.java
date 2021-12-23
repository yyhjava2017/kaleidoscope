package com.yyh.seckill.service.impl;

import com.yyh.seckill.pojo.User;
import com.yyh.seckill.mapper.UserMapper;
import com.yyh.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyhAuto
 * @since 2021-12-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(String mobile) {
        return userMapper.selectById(mobile);
    }
}
