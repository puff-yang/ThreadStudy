package com.controller;

import jdk.nashorn.internal.parser.JSONParser;
import org.junit.Test;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * @ClassName Student
 * @Description
 * @Author ymy
 * @Date 2020-07-22 10:02
 * @Version 1.0
 */
public class Student {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
//        StringBuilder sb=new StringBuilder();
//        for (int i=0;i<3;i++){
//            if (!"".equals(sb.toString())){
//                sb.append("、");
//            }
//                sb.append(i);
//
//        }
//        System.out.println(sb.toString());
//        Random random=new Random(new Date().getTime());
//
//        System.out.println((int)(Math.random()*100));
//        System.out.println((int)(Math.random()*100));
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100));
//        System.out.println(System.currentTimeMillis());
//        String str="12000012345678";
//        System.out.println(str.substring(6));

//        Calendar calendar=new GregorianCalendar();
//        calendar.add(Calendar.DATE,-1);
//        System.out.println(calendar.getTime());
//        List list;
//        System.out.println(list.size());

        String str="12010600001234";
        System.out.println(str.substring(6).replaceAll("^(0+)",""));
        System.out.println(Integer.parseInt(str));
    }

    @Test
    public void strJson(){
        Student student=new Student();
        student.setName("张三");
        student.setSex("女");

    }
}
