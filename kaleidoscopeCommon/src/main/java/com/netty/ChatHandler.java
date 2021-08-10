package com.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    //用来保存所有客户端链接
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:MM");

    //当channel中有新的事件，会自动调用
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {
        //获取客户端发送过来的文本消息
        String text = msg.text();
        System.out.println("接收到的消息："+text);
        for (Channel client : clients){
            client.writeAndFlush(new TextWebSocketFrame(dateFormat.format(new Date()))+":"+text);
        }
    }

    //当有新的客户端链接服务器后，会自动调用该方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
       clients.add(ctx.channel());
    }
}
