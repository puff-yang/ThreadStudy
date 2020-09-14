package com.study.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName PrintA1B2_Synchronized
 * @Description
 * @Author ymy
 * @Date 2020-09-13 21:12
 * @Version 1.0
 */
public class PrintA1B2_Synchronized {

    static PrintA1B2_Synchronized demo=new PrintA1B2_Synchronized();

    public synchronized void printNum(){
        for (int i = 1; i < 27; i++) {
            System.out.print(i);
            demo.notify();
            try {
                demo.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printLetter(){
        for (int i = 0; i < 26; i++) {
            System.out.print((char)('a'+i));
            demo.notify();
            try {
                demo.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(demo::printLetter).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(demo::printNum).start();

    }
}
