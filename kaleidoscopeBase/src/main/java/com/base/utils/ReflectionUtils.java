package com.base.utils;

import sun.rmi.log.LogInputStream;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @zz yyh
 * @time 2020-07
 */
public class ReflectionUtils {
    /**
     * 通过反射获取对象属性字符串
     */
    public static Map<String, Object> getFiledsStr(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        StringBuffer sbFileds = new StringBuffer();
        StringBuffer sbValues = new StringBuffer();
        //
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Field[] fatherFields = obj.getClass().getSuperclass().getDeclaredFields();
        if (fatherFields.length != 0) {
            List<Field> list = new ArrayList<Field>(Arrays.asList(declaredFields));
            list.addAll(Arrays.asList(fatherFields));
            declaredFields = list.toArray(new Field[declaredFields.length+fatherFields.length]);
        }
        for (int i = 0; i < declaredFields.length; i++) {
            if (i < declaredFields.length - 1) {
                sbFileds.append(declaredFields[i].getName());
                sbFileds.append(",");
                declaredFields[i].setAccessible(true);
                //如果是字符类型的数值，需要给值加上单引号
                if(declaredFields[i].get(obj) instanceof String){
                    sbValues.append("'");
                    sbValues.append(declaredFields[i].get(obj));
                    sbValues.append("'");
                }else{
                    sbValues.append(declaredFields[i].get(obj));
                }

                declaredFields[i].setAccessible(false);
                sbValues.append(",");
            } else {
                sbFileds.append(declaredFields[i].getName());
                declaredFields[i].setAccessible(true);
                sbValues.append(declaredFields[i].get(obj));
                declaredFields[i].setAccessible(false);
            }
        }
        map.put("fname",sbFileds.toString());
        map.put("fvalue",sbValues.toString());
        return map;

    }






}
