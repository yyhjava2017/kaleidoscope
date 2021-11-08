package com;

import com.netflix.client.config.DefaultClientConfigImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @zz yyh
 * @time 2020-08
 */
@SpringBootApplication
@MapperScan("com.user.dao")
@EnableEurekaClient
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }

    @Bean
    public DefaultClientConfigImpl iClientConfig(){
        return new DefaultClientConfigImpl();
    }
}
