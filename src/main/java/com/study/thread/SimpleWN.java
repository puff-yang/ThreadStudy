package com.study.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SimpleWN
 * @Description
 * @Author ymy
 * @Date 2020-07-07 10:53
 * @Version 1.0
 */
public class SimpleWN {

    static Object obj=new Object();

    public static class T1 extends Thread{
        public void run(){
            System.out.println("wait----开始调用时间="+System.currentTimeMillis());
            synchronized (obj){
                System.out.println("wait--获取同步锁时间="+System.currentTimeMillis());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait-----休息2s时间="+System.currentTimeMillis());
                try {
                    obj.wait();
                    System.out.println("wait-------唤醒结束="+System.currentTimeMillis());

                } catch (InterruptedException e) {
                    System.out.println();
                }
            }
        }
    }

    public static  class T2 extends Thread{
        public void run(){
            System.out.println("notify--开始调用时间="+System.currentTimeMillis());
            synchronized (obj){
                System.out.println("notify获取同步锁时间="+System.currentTimeMillis());
                obj.notify();
                try {
                    Thread.sleep(2000);
                    System.out.println("notify休眠结束释放锁="+System.currentTimeMillis());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static class T3 extends Thread{
        public void run(){
            System.out.println("T3开始竞争锁时间="+System.currentTimeMillis());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (obj){
                System.out.println("T3竞争到锁时间="+System.currentTimeMillis());
            }

        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        /*
         * 线程的实际执行顺序与代码的中的顺序不一致
         * 如下t1与t2同时竞争锁，当t2所代表的notify先竞争到锁时，t1代表的wait()竞争到锁时会一直wait
         */
        t3.start();
        t1.start();
        t2.start();
//        String number="-1";
//        if (Integer.parseInt(number)==-1){
//            System.out.println(true);
//        }
//        Date date=new Date();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//        System.out.println(sdf.format(date));
//    }
    }


}