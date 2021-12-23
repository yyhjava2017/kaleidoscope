package com.yyh.seckill.exception;

import com.yyh.seckill.pojo.Result;
import com.yyh.seckill.utils.ResultUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ExecptionHandler(Exception e){
        if(e instanceof GlobalException){
            GlobalException exception = (GlobalException) e;
            return ResultUtils.Exception(exception.getMessage());
        }else if(e instanceof BindException){
            BindException exception = (BindException) e;
            return ResultUtils.Exception("参数异常："+exception.getBindingResult().getAllErrors().get(0));
        }
        return ResultUtils.Exception("服务器异常");
    }
}
