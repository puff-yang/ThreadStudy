package com.study.thread.threadLocal;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T03_SoftReference
 * @Description 弱引用
 * @Author ymy
 * @Date 2020-09-15 10:56
 * @Version 1.0
 */
public class T03_SoftReference {
    public static void main(String[] args)  {
        SoftReference<byte[]> m=new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        byte[] bytes=new byte[1024*1024*10];

        System.out.println(m.get());

    }
}
