package com.study.thread.Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PrintA1B2_CyclicBarrier
 * @Description
 * @Author ymy
 * @Date 2020-09-13 21:44
 * @Version 1.0
 */
public class PrintA1B2_CyclicBarrier extends Thread{
    static CyclicBarrier numBarrier=new CyclicBarrier(1, new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 26; i++) {
                System.out.print((char)('a'+i));

            }
        }
    });
    static CyclicBarrier letterBarrier=new CyclicBarrier(1, new Runnable() {
        @Override
        public void run() {
            for (int i = 1; i < 27; i++) {
                System.out.print(i);

            }
        }
    });

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            try {
                numBarrier.await();
                letterBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            try {
                letterBarrier.await();
                numBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
