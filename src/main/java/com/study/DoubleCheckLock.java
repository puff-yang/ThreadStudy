package com.study;

/**
 * @ClassName DoubleCheckLock
 * @Description 双重验证单例模式
 * @Author ymy
 * @Date 2020-09-07 16:31
 * @Version 1.0
 */
public class DoubleCheckLock {

    private static volatile DoubleCheckLock doubleCheckLock;

    private DoubleCheckLock(){

    }


    public static DoubleCheckLock getInstance(){

        // A线程执行完为空判断，为空，但还未进入synchronized
        // 此时B线程进入synchronized中，new对象，退出锁
        // 线程A获取锁进入synchronized，此时再次new对象，单例模式失效
        if (doubleCheckLock==null){
            synchronized (DoubleCheckLock.class){
                if (doubleCheckLock==null){

                    //new() 分为三个过程 1、申请内存 2、将变量设为默认值 3、建立联系
                    doubleCheckLock=new DoubleCheckLock();
                }
            }
        }
        return doubleCheckLock;
    }

    public static void main(String[] args) {

    }
}
