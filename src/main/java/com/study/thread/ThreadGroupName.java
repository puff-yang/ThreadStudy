package com.study.thread;

/**
 * @ClassName ThreadGroupName
 * @Description
 * @Author ymy
 * @Date 2020-07-14 11:18
 * @Version 1.0
 */
public class ThreadGroupName implements Runnable {

    @Override
    public void run() {
        String threadName=Thread.currentThread().getThreadGroup().getName();
        if (1==1){
            System.out.println("My name is :"+threadName);

        }

    }

    public static void main(String[] args) {
        ThreadGroup tp=new ThreadGroup("PrintGroup");
        Thread t1=new Thread(tp,new ThreadGroupName(),"T1");
        Thread t2=new Thread(tp,new ThreadGroupName(),"T2");
        t1.start();
        t2.start();
        System.out.println(tp.activeCount());

    }
}
