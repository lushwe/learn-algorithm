package com.lushwe.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @author Jack Liu
 * @date 2020-05-17 09:36
 * @since 1.0
 */
public class Num0001 {

    public static void main(String[] args) {

        int[] nums = {1, 2};
        int target = 3;

        int[] result = new Num0001().twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i);
        }
    }


    private int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int temp = target - nums[i];

            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
