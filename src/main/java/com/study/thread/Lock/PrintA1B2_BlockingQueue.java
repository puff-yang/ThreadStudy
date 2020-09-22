package com.study.thread.Lock;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName PrintA1B2_BlockingQueue
 * @Description
 * @Author ymy
 * @Date 2020-09-16 22:42
 * @Version 1.0
 */
public class PrintA1B2_BlockingQueue {
    static ArrayBlockingQueue<String> q1=new ArrayBlockingQueue<String>(1);
    static ArrayBlockingQueue<String> q2=new ArrayBlockingQueue<String>(1);

    public static void main(String[] args) {
        char[] numPrint="12345".toCharArray();
        char[] letterPrint="ABCDE".toCharArray();
        new Thread(()->{
            for (char letter:letterPrint){
                System.out.print(letter);
                try {
                    q1.put("letterPrint");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (char num:numPrint){
                try {
                    //无论是那个线程先启动，只要q1为空，take便会阻塞等待，以此保证先输出字母
                    q1.take();
                    System.out.print(num);
                    q2.put("numPrint");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
