package com.utills;

import java.nio.ByteBuffer;

public class ByteBufferUtils {

    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("hello\ndgdggd\nhello\n".getBytes());
        split(source);
    }

    public static void split(ByteBuffer source){
        source.flip();
        for(int i=0;i<source.limit();i++){
            if(source.get(i)=='\n'){
                int length = i+1-source.position();
                ByteBuffer buffer = ByteBuffer.allocate(length);
                for(int j=0;j<length;j++){
                    buffer.put(source.get());
                }
                buffer.flip();
                byte[] target = new byte[buffer.limit()];
                buffer.get(target);
                System.out.println(new String(target));
            }
        }
    }
}
