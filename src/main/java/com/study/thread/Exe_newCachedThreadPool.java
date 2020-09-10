package com.study.thread;

import javax.xml.ws.WebServiceClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Exe_newCachedThreadPool
 * @Description
 * @Author ymy
 * @Date 2020-08-20 16:10
 * @Version 1.0
 */
public class Exe_newCachedThreadPool {

    public static class MyJob implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+"ThreadName-"+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyJob myJob=new MyJob();
        ExecutorService executor= Executors.newCachedThreadPool();
        for (int i=0;i<20;i++){
            executor.submit(myJob);
        }

        String str="123?45";
        System.out.println(str.substring(0,str.indexOf("?")));
    }
}
