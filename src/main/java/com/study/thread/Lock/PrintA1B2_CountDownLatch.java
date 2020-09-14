package com.study.thread.Lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName PrintA1B2_CountDownLatch
 * @Description
 * @Author ymy
 * @Date 2020-09-13 21:17
 * @Version 1.0
 */
public class PrintA1B2_CountDownLatch {

   static CountDownLatch numLatch=new CountDownLatch(1);
   static CountDownLatch letterLatch=new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        ThreadL threadL=new ThreadL();
        ThreadN threadN=new ThreadN();

        threadL.start();
        threadN.start();

    }

    static class ThreadL extends Thread{
    @Override
        public void run() {
            for (int i = 0; i <26 ; i++) {
                System.out.print((char)('a'+i));
                letterLatch.countDown();
                try {
                    numLatch.await();
                    numLatch=new CountDownLatch(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadN extends Thread{
        @Override
        public void run() {
            for (int i = 1; i <27 ; i++) {

                try {
                    letterLatch.await();
                    System.out.print(i);
                    letterLatch=new CountDownLatch(1);
                    numLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
