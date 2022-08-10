package com.yyh.seckill.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @zz yyh
 * @time 2020-07
 */
@ToString
@Getter
public enum StatusCode {

    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    BIND_ERROR(500220,"参数绑定异常"),
    LOGIN_ERROR(500210,"用户或者密码错误"),
    REBUY_ERROR(500410,"重复购买"),
    EMPTY_ERROR(500310,"库存不足");

    StatusCode(Integer code,String message){
        this.code = code;
        this.message=message;
    }

    private final Integer code;
    private final String message;

}
