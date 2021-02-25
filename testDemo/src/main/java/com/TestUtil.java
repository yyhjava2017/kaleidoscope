package com;

public class TestUtil {
    public static <T> T getNewInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {
        return cls.newInstance();
    }
    public static <T,E> void getGenericType(T arg,E... args) {
        for (E t : args){
            System.out.println(t+"hello");
        }
    }

    /**
     * 自定义一个数据字典注解@DataDictionary()
     */

}
