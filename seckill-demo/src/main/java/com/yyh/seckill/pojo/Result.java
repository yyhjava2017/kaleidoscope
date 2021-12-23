package com.yyh.seckill.pojo;

/**
 * @zz yyh
 * @time 2020-07
 */
public class Result {
    private int code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
