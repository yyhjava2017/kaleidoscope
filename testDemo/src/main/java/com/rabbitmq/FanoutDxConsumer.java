package com.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"email.fanout.queue","sms.fanout.queue"})
public class FanoutDxConsumer {

    @RabbitHandler
    public void handlerMsg(String message){
        System.out.println("短信已收到消息："+message);
    }
}
