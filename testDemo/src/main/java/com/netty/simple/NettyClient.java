package com.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

public class NettyClient {

    public static void main(String[] args) throws Exception {
        NettyClient.startClient01();
    }


    public static void startClient01() throws InterruptedException {
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());

                    }
                })
                .connect(new InetSocketAddress("localhost",8080))
                .sync()
                .channel()
                .writeAndFlush("hello");

    }


    public static void start() throws Exception{
        //事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            System.out.println("客户端准备好");
            //启动客户端去链接服务端
            ChannelFuture chabbelFuture = bootstrap.connect("127.0.0.1", 6688).sync();
            chabbelFuture.channel().closeFuture().sync();
        }finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
