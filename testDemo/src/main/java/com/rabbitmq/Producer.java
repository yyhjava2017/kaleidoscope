package com.rabbitmq;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class Producer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.57.128");
        connectionFactory.setUsername("user");
        connectionFactory.setPassword("password");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);

        Connection connection = null;
        Channel channel = null;

        try {
            connection  = connectionFactory.newConnection("hello");
            channel =   connection.createChannel();
            String queueName ="0830Test";
            channel.queueDeclare(queueName,false,false,false,null);
            String message = "hello001";
            channel.basicPublish("",queueName,null,message.getBytes());
            System.out.println("消息发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if(channel!=null &&channel.isOpen()){
                try {
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null && channel.isOpen()){
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
