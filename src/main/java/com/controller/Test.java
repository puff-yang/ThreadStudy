package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName Test
 * @Description
 * @Author ymy
 * @Date 2020-06-23 10:48
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        Date date=new Date();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));
        List<Student> list =new ArrayList<>();
        sortTest(list);
        for (Student out:list){
            System.out.println(out.getName());
        }

    }

    public static void sortTest(List<Student> list){
        Student student1=new Student();
        student1.setName("测试1");
        student1.setSex("女");
        Student student2=new Student();
        student2.setSex("男");
        student2.setName("测试2");
//        Student student3=new Student();
//        student3.setSex("通用");
//        student3.setName("测试3");
        Student student4=new Student();
        student4.setSex("通用");
        student4.setName("测试4");

        list.add(student1);
        list.add(student2);

        list.add(student4);
        //list.add(student3);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student stu1, Student stu2) {
                if ("测试3".equals(stu1.getName())){
                    return -1;
                }else {
                    return 1;
                }

            }
        });


        Student student5=new Student();
        student5.setSex("男");
        student5.setName("测试5");
        list.add(student5);

    }
}
