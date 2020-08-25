package com.lushwe.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：两数之和
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
