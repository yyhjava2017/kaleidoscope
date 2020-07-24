package com.user;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @zz yyh
 * @time 2020-07
 */
@SpringBootApplication
@MapperScan("com.user.dao")
public class UserApplication {

    public static void main(String[] args){
        SpringApplication.run(UserApplication.class,args);
    }
}
