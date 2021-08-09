package com.user.controller;

import com.alibaba.druid.util.StringUtils;
import com.base.entity.Result;
import com.base.utils.JwtUtils;
import com.base.utils.ResultUtils;
import com.base.utils.RsaUtils;
import com.user.service.IUserService;
import com.user.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import login.ILoginController;
import login.entity.LoginBO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.entity.UserEntity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("login")
@Api(description = "登录相关接口")
public class LoginController implements ILoginController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录接口")
    public Result login(HttpServletResponse response, @RequestBody LoginBO bo) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {

        String password = bo.getPassword();
        String username = bo.getLoginName();
        if(StringUtils.isEmpty(username))
            return ResultUtils.Fail("账号不能为空");
        if(StringUtils.isEmpty(password))
            return ResultUtils.Fail("密码不能为空");

        password = JwtUtils.password(password);
        bo.setPassword(password);
        UserEntity userEntity = userService.login(bo);
        if(userEntity == null){
            return ResultUtils.Fail("账号或密码错误");
        }
        //更新token
        String token = JwtUtils.generateTokenExpireInSeconds(userEntity, RsaUtils.getPrivateKey("D:\\mykey\\prikey"), 600);
        response.setHeader(JwtUtils.AUTH_HEADER_KEY, token);
        Map<String, Object> dataMap = new HashMap<>();
        //密码不能返回
        userEntity.setPassword(null);
        dataMap.put("userinfo", userEntity);
        return ResultUtils.Success(dataMap);
    }
}
