package com.base.utils;

import com.base.entity.Result;

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
        return new Result(200,"success","请求成功",data);
    }

}
