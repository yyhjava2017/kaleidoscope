package com.user.entitiy;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.user.security.CustomAuthorityDeserializer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUser implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private boolean accountNonExpired;


    public JwtUser() {
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {

        this.credentialsNonExpired = credentialsNonExpired;
    }

    private List<GrantedAuthority> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return username;
    }
    //继承后必须返回为true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //返回的值不能为null,否则返回的永远是null,就会一直没有权限，由此定义了一个authorities 属性并提供get方法，因为自
    // 定义了UserDetails，就没有在UserService中，使用到框架提供的User对象
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //不能返回null
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }

    //默认使用恒等去判断是否是同一个对象，因为登录的同一个用户，如果再次登录就会封装
    //一个新的对象，这样会导致登录的用户永远不会相等，所以需要重写equals方法
    @Override
    public boolean equals(Object obj) {
        //会话并发生效，使用username判断是否是同一个用户

        if (obj instanceof JwtUser){
            //字符串的equals方法是已经重写过的
            return ((JwtUser) obj).getUsername().equals(this.username);
        }else {
            return false;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
