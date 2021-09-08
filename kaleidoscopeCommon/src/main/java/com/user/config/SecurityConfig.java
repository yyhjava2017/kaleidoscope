package com.user.config;
import com.user.security.JwtAuthenticationProvider;
import com.user.security.JwtLoginFilter;
import com.user.security.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 通过让UserService实现UserDetailsService接口，而达到兼容性
     */
    @Autowired
    private UserDetailsService userServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
    @Autowired
    private AccessDecisionManager accessDecisionManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义登陆拦截器
        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter();
        jwtLoginFilter.setAuthenticationManager(authenticationManagerBean());
        jwtLoginFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        jwtLoginFilter.setAuthenticationFailureHandler(authenticationFailureHandler);

        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter();

        // 使用自定义验证实现器
        JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(userServiceImpl, passwordEncoder);

        // 登陆验证信息
        http.authenticationProvider(jwtAuthenticationProvider)
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                        object.setAccessDecisionManager(accessDecisionManager);
                        return object;
                    }
                })
                .anyRequest().authenticated()
                .and()
                .formLogin();

        // jwt 拦截器配置
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //禁用session
                .and()
                .csrf().disable()
                .addFilterAt(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class) // 添加拦截器
                .addFilterAfter(jwtTokenFilter, JwtLoginFilter.class);

        // 权限处理信息
        http.exceptionHandling()
                //   用来解决认证过的用户访问无权限资源时的异常
                .accessDeniedHandler(accessDeniedHandler)
                // 用来解决匿名用户访问无权限资源时的异常
                .authenticationEntryPoint(authenticationEntryPoint);


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/swagger-ui.html",
                        "/v2/api-docs", // swagger api json
                        "/swagger-resources/configuration/ui", // 用来获取支持的动作
                        "/swagger-resources", // 用来获取api-docs的URI
                        "/swagger-resources/configuration/security", // 安全选项
                        "/swagger-resources/**","/webjars/**");

    }
        @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }
}
