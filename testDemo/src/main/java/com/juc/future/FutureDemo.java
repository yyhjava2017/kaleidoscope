package com.juc.future;

import java.util.concurrent.*;


public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            int t = i;
            Future f = executorService.submit(()->{
                TimeUnit.SECONDS.sleep(2);
                return t+"123";
            });
            System.out.println(f.get());
        }

    }
}

class MyCallAble implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"执行call");
        return "hello";
    }
}
