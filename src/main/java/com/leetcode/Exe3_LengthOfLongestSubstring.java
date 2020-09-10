package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Exe3_LengthOfLongestSubstring
 * @Description
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @Author ymy
 * @Date 2020-08-19 15:36
 * @Version 1.0
 */
public class Exe3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //将字符串转为数组，data为ASCII码
        char[] charsArray=s.toCharArray();

        int[] map=new int[256];
        //初始化数组
        for (int i=0;i<charsArray.length;i++){
            map[i]=-1;
        }
        int result;
        int pre=-1;
        int current=0;
        //a最后一次出现位置，及a前一位推到的位置
        for (int i=0;i<map.length;i++){
            result=Math.max(pre,current);

        }

        return 1;
    }
}
