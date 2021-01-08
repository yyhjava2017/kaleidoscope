package com.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class JsonUtils {
    //ObjectMapper类是Jackson库的主要类。它提供一些功能将转换成Java对象匹配JSON结构，
    // 反之亦然。它使用JsonParser和JsonGenerator的实例实现JSON实际的读/写。
    public static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String toString(Object obj){
        if(obj==null){
            return null;
        }
        if(obj.getClass()==String.class){
            return (String)obj;
        }
        try{
            return mapper.writeValueAsString(obj);
        }catch (JsonProcessingException e){
            logger.error("json序列化出错"+obj,e);
            return null;
        }
    }

    public static <T> T toBean(String json,Class<T> tClass){
        try {
            return mapper.readValue(json,tClass);
        }catch (IOException e){
            logger.error("json解析出错"+json,e);
            return null;
        }
    }

    public <E> List<E> tiList(String json,Class<E> eClass) {
        try {
            return mapper.readValue(json,mapper.getTypeFactory().constructCollectionType(List.class,eClass));
        }catch (IOException e){
            logger.error("json解析出错"+json,e);
            return null;
        }
    }
}

