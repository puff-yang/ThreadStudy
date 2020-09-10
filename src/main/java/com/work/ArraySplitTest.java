package com.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ArraySplitTest
 * @Description
 * @Author ymy
 * @Date 2020-08-25 10:51
 * @Version 1.0
 */
public class ArraySplitTest {
    public static void main(String[] args) {
        String str1="[\"1\",\"2\"]";
        String str2="[\"3\",\"4\"]";
        String repal1=str1.replaceAll("\"","").replaceAll("\\[","").replaceAll("\\]","");

        String repal=str2.replaceAll("\"","").replaceAll("\\[","").replaceAll("\\]","");
        List<String> list=new ArrayList<>();
        list= Arrays.asList(repal);
        list= Arrays.asList(repal);
        System.out.println(list.toString());
    }
}
