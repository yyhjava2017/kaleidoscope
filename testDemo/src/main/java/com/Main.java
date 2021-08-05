package com;



public class Main {
    private static String obj1="aaa";
    private static String obj2="bbb";
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableA());
        Thread thread2 = new Thread(new RunnableB());
        thread1.start();
        thread2.start();

    }
    static class RunnableA implements  Runnable{
        @Override
        public void run() {
            synchronized (Main.obj1){
                System.out.println("线程1占用锁1");
                synchronized (Main.obj2){
                    System.out.println("线程1占用锁2");
                }
            }
        }
    }

    static class RunnableB implements  Runnable{
        @Override
        public void run() {
            synchronized (Main.obj2){
                System.out.println("线程2占用锁2");
                synchronized (Main.obj1){
                    System.out.println("线程2占用锁1");
                }
            }
        }
    }
}
