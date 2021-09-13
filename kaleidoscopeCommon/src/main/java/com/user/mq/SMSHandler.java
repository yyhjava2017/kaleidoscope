package com.user.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SMSHandler {

    @RabbitHandler
    @RabbitListener(queues = {"message.queue"})
    public void handlerMsg(String message){
        System.out.println("接收消息："+message);
    }
}
