package com.study.thread.threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TwoThreadConn
 * @Description
 * 实现一个容器，提供两个方法，add、size
 * 写两个线程，线程1添加10个元素到线程中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * @Author ymy
 * @Date 2020-09-12 17:14
 * @Version 1.0
 */
public class TwoThreadConn {


    /*
     * ArrayList本身不是线程安全的。
     *  在进行list中添加元素是先add，再将size+1
     *  这种情况在多线程时，可能出现t1线程add，还未size+1，此水t2线程读取到的size是不对的，出现脏读
     *  所以下面的写法是不对的，应该使用同步容器
     *  volatile List<Object> list=new ArrayList<>();
     *
     *  添加volatile是为了使线程之间能够感知到list的变化
     */

    volatile List<Object> list= Collections.synchronizedList(new ArrayList<>());

   /**
    * @author: ymy
    * @Description:
    * @Date: 2020-09-12 17:52
    * @Param [t]
    * @return void
    */
    public void add(Object t){
        list.add(t);
        System.out.println(Thread.currentThread().getName()+"list中个数为："+list.size());
    }


    public int size(){
      return list.size();
    }

    public static void main(String[] args) {
        TwoThreadConn twoThreadConn=new TwoThreadConn();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                twoThreadConn.add(1);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
               while (true){
                   if (twoThreadConn.size()==5) break;
               }
            System.out.println(Thread.currentThread().getName()
            +"list中条数为5，线程结束");
        },"t2").start();

    }
}
