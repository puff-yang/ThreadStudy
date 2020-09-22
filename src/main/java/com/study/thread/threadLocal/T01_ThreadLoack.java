package com.study.thread.threadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T01_ThreadLoack
 * @Description
 * @Author ymy
 * @Date 2020-09-14 21:42
 * @Version 1.0
 */
public class T01_ThreadLoack {

    static ThreadLocal<Student> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        },"t1").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Student());
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get().name);

        },"t2").start();
    }
    static class Student{
        String name="张三";
    }
}
