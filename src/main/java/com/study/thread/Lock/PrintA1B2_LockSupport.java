package com.study.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName PrintA1B2_LockSupport
 * @Description
 * @Author ymy
 * @Date 2020-09-13 20:29
 * @Version 1.0
 */
public class PrintA1B2_LockSupport {

    static Thread t1=null,t2=null;
    static final Thread t3=null;
    public static void main(String[] args) throws InterruptedException {

        //Thread t1=null,t2=null;
        t1=new Thread(()->{
            for (int i = 0; i <26 ; i++) {
                System.out.print((char)('a'+i));
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2=new Thread(()->{
            for (int i = 1; i < 27; i++) {
                System.out.print(i);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });
        t2.start();
    }
}
