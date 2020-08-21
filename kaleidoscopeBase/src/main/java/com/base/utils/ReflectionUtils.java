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
                String rawfiled = declaredFields[i].getName();
                //加入驼峰命名转化
                sbFileds.append(toHumpNaming(rawfiled));
                sbFileds.append(",");
                declaredFields[i].setAccessible(true);
                //如果是字符类型的数值，需要给值加上单引号
                getValue(declaredFields[i].get(obj),sbValues);

                declaredFields[i].setAccessible(false);
                sbValues.append(",");
            } else {
                sbFileds.append(declaredFields[i].getName());
                declaredFields[i].setAccessible(true);
                //如果是字符类型的数值，需要给值加上单引号
                getValue(declaredFields[i].get(obj),sbValues);
                declaredFields[i].setAccessible(false);
            }
        }
        map.put("fname",sbFileds.toString());
        map.put("fvalue",sbValues.toString());
        return map;

    }
    private static void getValue(Object obj,StringBuffer sbValues ){
        if(obj instanceof String){
            sbValues.append("'");
            sbValues.append(obj);
            sbValues.append("'");
        }else{
            sbValues.append(obj);
        }
    }
    public static String toHumpNaming(String rawStr){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<rawStr.length();i++){
            char c = rawStr.charAt(i);
            if(Character.isUpperCase(c)){
                sb.append("_"+Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }




}
