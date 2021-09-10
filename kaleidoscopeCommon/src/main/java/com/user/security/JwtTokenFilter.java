package com.user.security;

import com.base.utils.JsonUtils;
import com.user.entitiy.JwtUser;
import com.user.utill.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter{
    private RedisTemplate redisTemplate;

    public JwtTokenFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = httpServletRequest.getHeader("kale-token");
            if (StringUtils.isEmpty(token)) {
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                System.out.println("未登录");
                return;
            }

            Claims claims = JwtUtils.parseJWT(token);
            if (JwtUtils.isTokenExpired(claims)) {
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                System.out.println("登陆时效已过，请重新登陆");
                return;
            }
            //通过token去redis获取User,如果成功就放行
            String valstr = (String) redisTemplate.opsForValue().get(token);
            JwtUser user = JsonUtils.toBean(valstr,JwtUser.class);
            System.out.println(user);
            JwtLoginToken jwtLoginToken = new JwtLoginToken(user, "", user.getAuthorities());
            jwtLoginToken.setDetails(new WebAuthenticationDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(jwtLoginToken);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadCredentialsException("登陆凭证失效，请重新登陆");
        }

    }

}
