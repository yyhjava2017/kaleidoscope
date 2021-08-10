package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebSocketServer {

    private EventLoopGroup bossGroup;       //主线程池
    private EventLoopGroup workerGroup;     //工作线程池
    private ServerBootstrap bootstrap;      //服务器
    private ChannelFuture future;           //回调

    public void start(){
        future = bootstrap.bind(9002);
        log.info("netty Server 启动");
    }

    public WebSocketServer() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WebSocketInitializer());
    }
}
