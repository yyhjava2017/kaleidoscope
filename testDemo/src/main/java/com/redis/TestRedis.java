package com.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(JUnit4.class)
public class TestRedis {

    @Test
    public  void test111(){
        String redisKey = "redisTest";
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            Jedis jedis = new Jedis("127.0.0.1",6379);
            jedis.set(redisKey,"0");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        for (int i=0;i<10000;i++){
            executorService.execute(()->{
                Jedis jedis1 = new Jedis("127.0.0.1",6379);
                try {
                    jedis1.watch(redisKey);
                    String redisValue = jedis1.get(redisKey);
                    int valInteger = Integer.valueOf(redisValue);
                    String userInfo = UUID.randomUUID().toString();
                    if (valInteger<20){
                        Transaction transaction = jedis1.multi();
                        transaction.incr(redisKey);
                        List list = transaction.exec();
                        if (list!=null){
                            System.out.println("用户："+userInfo+"，秒杀成功！当前成功人数："+(valInteger+1));
                        }else {
                            System.out.println("用户："+userInfo+"，秒杀失败");
                        }
                    }else {
                        System.out.println("已经有20人秒杀成功，秒杀结束");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    jedis1.close();
                }
            });
        }
        executorService.shutdown();
    }



}
