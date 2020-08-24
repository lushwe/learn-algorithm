package com.lushwe.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * 说明：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * leetcode地址：https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author Jack Liu
 * @date 2020-8-24 11:00
 * @since 0.1
 */
public class Num0088 {

    public static void main(String[] args) {

        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};

        merge(num1, 3, num2, 3);

        System.out.println(JSON.toJSONString(num1));
    }

    /**
     * 合并
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while (index2 >= 0) {
            if (index1 >= 0 && nums1[index1] >= nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
    }
}
