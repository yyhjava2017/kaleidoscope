package com.netty.entity;

import lombok.Data;

@Data
public class Message {
    private String type;        //消息类型
    private ChatRecord chatRecord;  //聊天消息
    private Object ext;         //扩展消息字段
}
