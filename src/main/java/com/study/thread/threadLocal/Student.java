package com.study.thread.threadLocal;

/**
 * @ClassName Student
 * @Description
 * @Author ymy
 * @Date 2020-09-15 10:51
 * @Version 1.0
 */
public class Student {
    private String name;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Already gc..");
    }
}
