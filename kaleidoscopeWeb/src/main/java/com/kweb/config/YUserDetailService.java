package com.kweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class YUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 根据用户名获得用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encode = passwordEncoder.encode("123456");
        //此处密码encode，不能使用明文，spring5.x要求,否则会抛以下异常，需用PasswordEncoder加密
        //java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority("IU_ADD"));
        User user = new User(username,encode,list);
        return user;
        //AuthorityUtils.commaSeparatedStringToAuthorityList()：将字符串分割生产authority对象的list
        //return new User(username,encode, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }
}
