package com.yyh.seckill.exception;

import com.yyh.seckill.pojo.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GlobalException extends RuntimeException{
    private Result result;
    public GlobalException(String msg){
        super(msg);
    }
}
