package com.study.thread.Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName PrintA1B2_CyclicBarrier3
 * @Description
 * @Author ymy
 * @Date 2020-09-14 15:42
 * @Version 1.0
 */
public class PrintA1B2_CyclicBarrier3 {
    public static void main(String[] args) {
        CyclicBarrier letterBarrier=new CyclicBarrier(1);
        CyclicBarrier numBarrier=new CyclicBarrier(1);
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                System.out.print((char)('a'+i));

                try {
                    letterBarrier.await();
                    //numBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 1; i <=26; i++) {

                try {
                    letterBarrier.await();
                    System.out.print(i);
                    //numBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
