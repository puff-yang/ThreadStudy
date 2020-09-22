package com.study.thread.Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName PrintA1B2_CyclicBarrier2
 * @Description
 * @Author ymy
 * @Date 2020-09-14 14:30
 * @Version 1.0
 */
public class PrintA1B2_CyclicBarrier2 {

    static CyclicBarrier cyclicBarrierL=new CyclicBarrier(2);
    static CyclicBarrier cyclicBarrierN=new CyclicBarrier(2);


    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 26; i++) {
                    System.out.print((char)('a'+i) );
                    try {
                        cyclicBarrierL.await();
                        cyclicBarrierN.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 26; i++) {

                    try {
                        cyclicBarrierL.await();
                        System.out.print(1+i);
                        cyclicBarrierN.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



    }
}
