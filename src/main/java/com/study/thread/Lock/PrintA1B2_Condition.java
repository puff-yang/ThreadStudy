package com.study.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName PrintA1B2_Condition
 * @Description
 * @Author ymy
 * @Date 2020-09-13 20:13
 * @Version 1.0
 */
public class PrintA1B2_Condition {

    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        Condition printNum=lock.newCondition();
        Condition printLetter=lock.newCondition();

        new Thread(()->{
            lock.lock();
            for (int i = 0; i < 26; i++) {
                System.out.print((char)('a'+i));
                printNum.signal();

                try {
                    printLetter.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //printNum.signal();
        }).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(()->{
            lock.lock();
            for (int i = 1; i < 27; i++) {
                System.out.print(i);
                printLetter.signal();

                try {
                    printNum.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //保证线程最后不是处于await状态，否则将一直等待无法退出
            printLetter.signal();
        }).start();




    }
}
