package com.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.HashMap;
import java.util.Map;

public class UserChannelMap {
    private static Map<String, Channel> userChannelMap;//用于存储用户和通道的关系

    static {
        userChannelMap = new HashMap<>();
    }

    public static void put(String id,Channel channel){
        userChannelMap.put(id,channel);
    }

    public static Channel remove(String id){
        return userChannelMap.remove(id);
    }

    public static void print(){
        for(String s:userChannelMap.keySet()){
            System.out.println("用户id:"+s+"------通道："+userChannelMap.get(s).id());
        }
    }

    /**
     * 根据通道id删除key-velue
     * @param channelId
     */
    public static void removeByChannelId(String channelId){
        for(String s:userChannelMap.keySet()){
            String cid = userChannelMap.get(s).id().asLongText();
            if(channelId.equals(cid)){
                System.out.println("客户端链接断开，取消用户"+s+"与通道"+cid+"的关联");
                userChannelMap.remove(cid);
                break;
            }

        }
    }
}
