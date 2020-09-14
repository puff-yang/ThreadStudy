package com.study.thread.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @Description
 * @Author ymy
 * @Date 2020-09-12 21:59
 * @Version 1.0
 */
public class Test {

    final int  MAX=10;
    final LinkedList<Object> list=new LinkedList<>();

    static Thread t2=null,t1=null;

    public synchronized void put () {

        if (list.size()==MAX){
            try {
                System.out.println(Thread.currentThread().getName()+"put中已满");
                this.wait();
                System.out.println("唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("添加元素");

        list.add(new Object());
        this.notifyAll();
    }

    public synchronized void get()  {
        while (list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.removeFirst();
        System.out.println(Thread.currentThread().getName()+"get中移除");
        this.notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {

        Test test=new Test();

        t1=new Thread(()->{
            for (int i = 0; i < 15; i++) {
            test.put();
            }
        },"putMethod");

        t1.start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("休息三秒");

        t2=new Thread(()->{
            for (int i = 0; i < 2; i++) {
            test.get();
            }
        },"getMethod");

        t2.start();
        //t2.join();
        //System.out.println("长度为："+list.size());

    }
}
