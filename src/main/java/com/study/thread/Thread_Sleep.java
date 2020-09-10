package com.study.thread;

/**
 * @ClassName Thread_Sleep
 * @Description
 * @Author ymy
 * @Date 2020-09-08 16:25
 * @Version 1.0
 */
public class Thread_Sleep {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("开始进入线程");
            try {
                Thread.sleep(1000);
                System.out.println("线程sleep中");
            } catch (InterruptedException e) {
                e.printStackTrace();//
            }
            System.out.println("线程结束");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        System.out.println("----");
        new MyThread().notify();

    }


}
