package com.middleware.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutDxConsumer {

    @RabbitHandler
    @RabbitListener(queues = {"sms.fanout.queue"})
    public void handlerMsg(String message){
        System.out.println("短信已收到消息："+message);
    }
}
