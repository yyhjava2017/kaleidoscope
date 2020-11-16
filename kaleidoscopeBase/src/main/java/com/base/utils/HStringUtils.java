package com.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class HStringUtils {
    private static String hasPropertiesNull(Object obj,Class cls){
        String cname = cls.getName();
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field f : declaredFields){
            f.setAccessible(true);//使私有属性可以访问
            int modifiers = f.getModifiers();
            if(Modifier.isFinal(modifiers)&&Modifier.isStatic(modifiers)){//常量字段不处理
                continue;
            }
            Object fieldVal;
            try{
                fieldVal = f.get(obj);
                boolean isNull = isEmpty(fieldVal);
                if(isNull){
                    return "属性："+f.getName()+"不可为空";
                }
            }catch (Exception e){
                return "error："+e.getMessage();
            }
        }
        //当前类不是Object
        if (!cname.equals("java.lang.Object")) {
            hasPropertiesNull(obj,cls.getSuperclass());
        }
        return "no";
    }

    private static boolean isEmpty(Object valObj){
        if(valObj == null){
            return true;
        }else if(valObj instanceof String&&String.valueOf(valObj).equals("")){
            return true;
        }else{
            return false;
        }
    }
}
