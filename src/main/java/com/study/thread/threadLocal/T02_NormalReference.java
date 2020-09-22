package com.study.thread.threadLocal;

import java.io.IOException;

/**
 * @ClassName T02_NormalReference
 * @Description 强引用
 * @Author ymy
 * @Date 2020-09-15 10:49
 * @Version 1.0
 */
public class T02_NormalReference {
    public static void main(String[] args) throws IOException {

        Student student = new Student();
        //student=null意为没有引用指向Student，调用gc时会回收
        student=null;
        System.gc();
        //阻断当前main线程。由于gc是跑在别的线程中，如果不阻断，退出main方法，gc无意义看不出效果
        System.in.read();


    }
}
