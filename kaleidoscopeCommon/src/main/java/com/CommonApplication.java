package com;

import com.netflix.client.config.DefaultClientConfigImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @zz yyh
 * @time 2020-08
 */
@SpringBootApplication
@MapperScan("com.user.dao")
@EnableDiscoveryClient //开启服务发现功能
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }

    @Bean
    public DefaultClientConfigImpl iClientConfig(){
        return new DefaultClientConfigImpl();
    }
}
