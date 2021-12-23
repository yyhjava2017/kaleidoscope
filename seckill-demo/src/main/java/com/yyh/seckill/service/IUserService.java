package com.yyh.seckill.service;

import com.yyh.seckill.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yyhAuto
 * @since 2021-12-21
 */
public interface IUserService extends IService<User> {

    User queryById(String mobile);
}
