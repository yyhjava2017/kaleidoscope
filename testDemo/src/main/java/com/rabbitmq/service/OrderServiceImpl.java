package com.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl {

    @Autowired
    private RabbitTemplate template;

    public void makeOrder(String userid,String productid,int num){
        //查看库存是否充足
        //保存订单
        String orderid = UUID.randomUUID().toString();
        System.out.println("订单生产成功:"+orderid);
        String exchangeName ="fanout_out_exchange";
        String routingKey ="";
        template.convertAndSend(exchangeName,routingKey,orderid);
    }
}
