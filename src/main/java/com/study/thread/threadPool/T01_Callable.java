package com.study.thread.threadPool;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @ClassName T01_Callable
 * @Description
 * @Author ymy
 * @Date 2020-09-20 13:03
 * @Version 1.0
 */
public class T01_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable=new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "hello callable";
            }
        };

        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Future<String> future= executorService.submit(callable);//异步

        System.out.println(future.get());//阻塞

        executorService.shutdown();

        System.out.println("main结束");

        //FutureTask

    }
}
