package com.study.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LockSupport1
 * @Description
 * @Author ymy
 * @Date 2020-09-12 17:05
 * @Version 1.0
 */
public class LockSupport1 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i==5) LockSupport.park();
                if (i==7) LockSupport.park();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        LockSupport.unpark(t1);
    }
}
