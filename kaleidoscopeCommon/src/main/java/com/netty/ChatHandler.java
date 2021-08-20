package com.netty;

import com.base.utils.ApplicationContextUtils;
import com.base.utils.JsonUtils;
import com.netty.entity.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    //用来保存所有客户端链接
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:MM");

    //当channel中有新的事件，会自动调用
    //测试消息：{"type":"0","chatRecord" :{"userId":"001"},"ext":"hello"}
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        //获取客户端发送过来的文本消息
        String text = msg.text();
        System.out.println("接收到的消息："+text);
        Message message = JsonUtils.toBean(text,Message.class);
        switch (message.getType()){
            case "0":
                String userId = message.getChatRecord().getUserId();
                UserChannelMap.put(userId,ctx.channel());
                System.out.println("用户："+userId+" channel:"+ctx.channel().id()+" 建立链接");
                break;
            case "1":
                //实现聊天功能
                ApplicationContextUtils.getObject("");
        }
    }

    /**
     * 异常时触发
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("通道异常关闭");
        UserChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        ctx.channel().close();
    }

    /**
     * 通道关闭触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("通道关闭");
        UserChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        UserChannelMap.print();
    }


    //当有新的客户端链接服务器后，会自动调用该方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
       clients.add(ctx.channel());
    }
}
