package com.study.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName PrintA1B2_Synchronized
 * @Description  此种写法无法保证先输出字母
 * @Author ymy
 * @Date 2020-09-13 21:12
 * @Version 1.0
 */
public class PrintA1B2_Synchronized {



    public static void main(String[] args) throws InterruptedException {
        PrintA1B2_Synchronized demo=new PrintA1B2_Synchronized();

        new Thread(()->{
            synchronized (demo){
                for (int i = 0; i < 26; i++) {
                    System.out.print((char)('a'+i));
                    demo.notify();
                    try {
                        demo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                demo.notify();
        }}).start();

        new Thread(()->{
            synchronized (demo){
                for (int i = 0; i < 26; i++) {
                    try {
                        //先wait存在问题，只能先notify。但先notify存在不能保证先输出字母的问题
                        demo.wait();
                        System.out.print(i);
                        demo.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                demo.notify();
            }}).start();


    }
}
