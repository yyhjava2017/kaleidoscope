package com.yyh.seckill.utils;


import com.yyh.seckill.pojo.Result;
import com.yyh.seckill.pojo.StatusCode;

public class ResultUtils {
    /**
     * 请求成功-不含返回数据
     * @return
     */
    public static Result Success(){
        return Success(null);
    }
    /**
     * 请求成功-含返回数据
     * @param data
     * @return
     */
    public static Result Success(Object data){
        return new Result(StatusCode.SUCCESS,data);
    }

    /**
     *异常返回
     */
    public static Result Exception(String msg){
        return new Result(StatusCode.BIND_ERROR,msg);
    }

    public static Result Fail(String errmsg) {
        return Fail(StatusCode.ERROR.getCode(), errmsg);
    }
    /**
     * 失败
     * @param errmsg 错误信息
     */
    public static Result Fail(Integer code, String errmsg) {
        Result commonResult = new Result();
        commonResult.setCode(code);
        commonResult.setMessage(errmsg);
        return commonResult;
    }
}
