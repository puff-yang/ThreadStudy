package com.study.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLock3
 * @Description
 * ReentrantLock在锁等待中可以通过interrupt进行打断停止打断
 * @Author ymy
 * @Date 2020-09-11 14:26
 * @Version 1.0
 */
public class ReentrantLock3 {

    ReentrantLock lock=new ReentrantLock();

    void m1(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"：m1获取到锁--start" );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName()+"：m1释放锁--end" );
    }

    void m2(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"：m2获取到锁--start" );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName()+"：m2释放锁--end" );
    }

    //tryLock设置获取锁的等待时间，2s之内没有相应，则不继续等待
    void m3(){
        boolean isLock=false;
        try {
            isLock=lock.tryLock(2000, TimeUnit.MILLISECONDS);
            System.out.println("don't wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (isLock) lock.unlock();
        }
        System.out.println(Thread.currentThread().getName()+"：锁的状态为"+isLock);

    }

    void m4(){
        try {
            //interrupt可打断等待锁的过程
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"：线程被打断");
        } finally {
            //todo 此处释放锁的写法待定
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock3 demo=new ReentrantLock3();

        new Thread(demo::m1).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(demo::m3).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(demo::m2).start();

        Thread t4=new Thread(demo::m4);
        t4.start();
        t4.interrupt();


    }
}
