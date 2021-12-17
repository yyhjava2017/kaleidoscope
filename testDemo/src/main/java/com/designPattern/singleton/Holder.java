package com.designPattern.singleton;

/**
 * 静态内部类的方式
 */
public class Holder {

    public static  String hhh = "hello";
    private static Holder getInstance(){
        return Inner.INSTANCE;
    }

    private Holder(){
        System.out.println("Holder被构造");
    }
    /**
     * 外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存
     */
    public static class Inner{
        private static Holder INSTANCE = new Holder();
    }

    public static void main(String[] args) {
        System.out.println(Holder.hhh);
        System.out.println("hello2313");
        System.out.println(Holder.getInstance());

    }
}
