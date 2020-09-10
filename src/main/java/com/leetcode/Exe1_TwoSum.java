package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Exe1_TwoSum
 * @Description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *     给定 nums = [2, 7, 11, 15], target = 9
 *     因为 nums[0] + nums[1] = 2 + 7 = 9
 *     所以返回 [0, 1]
 *
 * @Author ymy
 * @Date 2020-08-19 14:06
 * @Version 1.0
 */
public class Exe1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);

        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Exe1_TwoSum exe=new Exe1_TwoSum();
        int result[]=exe.twoSum(new int[]{2, 7, 8, 15},15);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}
