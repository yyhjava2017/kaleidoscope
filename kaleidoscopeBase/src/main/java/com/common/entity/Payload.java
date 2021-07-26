package com.common.entity;



import lombok.Data;

import java.util.Date;

@Data
public class Payload<T> {
    private String id;  // jwt的id(token)
    private T userInfo;  // 用户信息：用户数据，不确定，可以是任意类型
    private Date expiration;  // 过期时间

}
