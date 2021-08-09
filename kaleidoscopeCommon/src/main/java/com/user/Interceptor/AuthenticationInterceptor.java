package com.user.Interceptor;

import com.base.entity.Payload;
import com.base.utils.JwtUtils;
import com.base.utils.RsaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import user.entity.UserEntity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从http请求头中取出token
        final String token = request.getHeader(JwtUtils.AUTH_HEADER_KEY);
        Payload<Object> infoFromToken = JwtUtils.getInfoFromToken(token, RsaUtils.getPublicKey("D:\\mykey\\pubkey"));
        UserEntity userInfo = (UserEntity) infoFromToken.getUserInfo();
        System.out.println(userInfo.getId());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //方法结束后，移除缓存的token
        //WebContextUtil.removeUserToken();
    }
}
