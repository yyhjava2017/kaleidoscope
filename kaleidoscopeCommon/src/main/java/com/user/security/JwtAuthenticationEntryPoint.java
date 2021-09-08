package com.user.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        /*JsonResult<String> jsonResult = new JsonResult<>();
        jsonResult.setFail(JsonResponseStatus.NoRight.getCode(), "权限不足 :" + authException.getMessage());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(jsonResult));*/
        System.out.println("用户访问资源没有携带正确的token");
        System.out.println(e.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e==null?"用户访问资源没有携带正确的token":e.getMessage());
    }
}
