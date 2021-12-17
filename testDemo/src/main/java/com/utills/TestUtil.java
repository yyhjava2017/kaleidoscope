package com.utills;

import java.nio.ByteBuffer;

public class TestUtil {

    public static void readByteBuffer(ByteBuffer byteBuffer){
        StringBuffer mes = new StringBuffer();
        while(byteBuffer.hasRemaining()){
            mes.append(byteBuffer.get());
        }
        System.out.println(mes);
    }

}
