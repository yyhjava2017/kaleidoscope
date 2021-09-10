package com.user.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.constant.TableName;
import com.base.entity.Result;
import com.base.entity.StatusCode;
import com.base.utils.JwtUtils;
import com.user.dao.UserMapper;
import com.user.entitiy.JwtUser;
import com.user.service.IUserService;
import login.entity.LoginBO;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import user.entity.UserEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * @zz yyh
 * @time 2020-07
 */
@Service
public class UserServiceImpl implements IUserService, UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result update(UserEntity userEntity) {
        userMapper.update(userEntity);
        return new Result(StatusCode.SUCCESS,"success","更新成功",null);
    }

    @Override
    public UserEntity login(LoginBO bo) {
        return userMapper.login(bo);
    }

    @Override
    public Result regist(UserEntity userEntity){
        System.out.println("login");
        String password = userEntity.getPassword();
        String password1 = JwtUtils.password(password);
        userEntity.setPassword(password1);
        userMapper.insert(userEntity);
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

    @Override
    public JwtUser loadUserByUsername(String userName) throws UsernameNotFoundException {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_Name",userName);
        UserEntity userEntity = userMapper.selectOne(queryWrapper);
        if(userEntity==null){
            throw new UsernameNotFoundException("账号或者密码错误，请重新登录!");
        }
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        JwtUser user = new JwtUser();
        user.setUsername(userEntity.getLoginName());
        user.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        user.setAuthorities(auth);
        return user;
    }
}
