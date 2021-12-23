package com.yyh.seckill.controller;

import com.yyh.seckill.exception.GlobalException;
import com.yyh.seckill.pojo.LoginVO;
import com.yyh.seckill.pojo.Result;
import com.yyh.seckill.pojo.User;
import com.yyh.seckill.service.IUserService;
import com.yyh.seckill.utils.MD5Util;
import com.yyh.seckill.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Result doLogin(@Valid LoginVO vo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = vo.getMobile();
        String password = vo.getPassword();
        //省略校验手机号码

        User user = userService.queryById(mobile);
        if (user == null) {
            throw new GlobalException("该用户不存在");
        }
        //判断密码是否正确
        if(!MD5Util.fromPass2DbPass(password,user.getSalt()).equals(user.getPassword())){
            throw new GlobalException("密码错误");
        }
        //String ticket = UUID.randomUUID().toString();
        request.getSession().setAttribute("user",user);
        return ResultUtils.Success("登录成功！");
    }
}
