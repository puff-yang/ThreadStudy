package com.study.thread.Lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReadWriteLockDemo
 * @Description 读写锁分离 ReentrantReadWriteLock
 * @Author ymy
 * @Date 2020-07-21 14:09
 * @Version 1.0
 */
public class ReadWriteLockDemo {

    private static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    private static Lock readLock=readWriteLock.readLock();

    private static Lock writeLock=readWriteLock.writeLock();

    private static int value;

    private static ReentrantLock lock=new ReentrantLock();
    //volatile


    public Object handleReadLock(Lock lock){

        try {
            lock.lock();
            System.out.println("读线程获取临界区资源："+Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("读线程名称为："+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return value;
    }
    public void handleWriteLock(Lock lock,int index){

        try {
            lock.lock();
            Thread.sleep(1000);
            value=index;
            System.out.println("WriteLock成功写入，value值="+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo=new ReadWriteLockDemo();

        Runnable readRunnable=new Runnable() {
            @Override
            public void run() {
                demo.handleReadLock(readLock);
//                demo.handleReadLock(lock);
            }
        };

        Runnable writeRunnable=new Runnable() {
            @Override
            public void run() {
                demo.handleWriteLock(writeLock,new Random().nextInt());
//                demo.handleWriteLock(lock,new Random().nextInt());
            }
        };

        for (int i=0;i<18;i++){
            new Thread(readRunnable).start();
        }
        for (int i=18;i<20;i++){
            new Thread(writeRunnable).start();
        }


    }

}
