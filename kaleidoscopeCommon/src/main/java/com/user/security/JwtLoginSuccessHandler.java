package com.user.security;

import com.base.utils.JsonUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String json = JsonUtils.toString(userDetails); //JSON.toJSONString(jwtUserDetails);
        String jwtToken = JwtUtils.createJwtToken(json, 6000);
        String resStri = "{\"success\":true,\"errorCode\":null,\"errorMsg\":null,\"data\":{\"token:\""+jwtToken+"}}";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(resStri);
    }
}
