package com.study.thread.Lock;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName AtomicVsSynchronizeVsLongAdder
 * @Description
 * Atomic、Synchronize、LongAdder 三种方法效率的比较
 * 在不同情况效率不同，示例仅代表在如下情况
 * @Author ymy
 * @Date 2020-09-11 10:34
 * @Version 1.0
 */
public class AtomicVsSynchronizeVsLongAdder {

    long count1=0L;
    AtomicLong count2=new AtomicLong(0L);
    LongAdder count3=new LongAdder();

    public synchronized void m1(){
        for (int i=0;i<10000;i++){
            count1++;
        }
    }

    public void m2(){
        for (int i=0;i<10000;i++){
            count2.incrementAndGet();
        }

    }

    public void m3(){
        for (int i=0;i<10000;i++){
            //count3;
        }
    }

}
