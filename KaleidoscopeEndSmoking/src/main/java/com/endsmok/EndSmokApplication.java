package com.endsmok;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @zz yyh
 * @time 2020-08
 */
@SpringBootApplication
@MapperScan("com.endsmok.dao")
public class EndSmokApplication {
    public static void main(String[] args) {
        SpringApplication.run(EndSmokApplication.class);
    }
}
