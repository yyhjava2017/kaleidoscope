package com.netty;

import com.utills.TestUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Slf4j
public class TestServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        SelectionKey key = ssc.register(selector,SelectionKey.OP_ACCEPT,null);
        ssc.bind(new InetSocketAddress(8080));
        ByteBuffer byteBuffer  = ByteBuffer.allocate(16);
        while(true){
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey nextKey = iterator.next();
                if (nextKey.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) nextKey.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ,null);
                    log.debug("acceptChannel=>"+channel);
                }else if (nextKey.isReadable()) {
                    try{
                        SocketChannel channel = (SocketChannel) nextKey.channel();
                        int read = channel.read(byteBuffer);
                        if(read==-1){
                            nextKey.cancel();
                        }
                        byteBuffer.flip();
                        System.out.println(Charset.defaultCharset().decode(byteBuffer));
                        byteBuffer.clear();
                    }catch (Exception e){
                        e.printStackTrace();
                        nextKey.cancel();
                    }

                }
                //使用完成，要手动删除
                iterator.remove();
            }
        }
    }
}
