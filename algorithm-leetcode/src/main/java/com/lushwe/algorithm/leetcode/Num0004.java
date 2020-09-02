package com.lushwe.algorithm.leetcode;

/**
 * 说明：4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * @author Jack Liu
 * @date 2019-12-03 17:29
 * @since 0.1
 */
public class Num0004 {

    public static void main(String[] args) {


        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8};

        System.out.println(find(arr1, arr2));

        // arr1, 0, 3, arr2, 0, 8, 7

    }


    public static double find(int[] arr1, int[] arr2) {

        int len1 = arr1.length;
        int len2 = arr2.length;

        int restlt1 = find(arr1, 0, len1 - 1, arr2, 0, len2 - 1, (len1 + len2 + 1) / 2);
        int restlt2 = find(arr1, 0, len1 - 1, arr2, 0, len2 - 1, (len1 + len2) / 2 + 1);

        return (restlt1 + restlt2) * 0.5;

    }


    public static int find(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2, int pos) {

        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) {
            return find(arr2, start2, end2, arr1, start1, end1, pos);
        }

        if (len1 == 0) {
            return arr2[start2 + pos - 1];
        }

        if (pos == 1) {
            return Math.min(arr1[start1], arr2[start2]);
        }

        // 找中位数
        int pos1 = start1 + Math.min(pos / 2, len1) - 1;
        int pos2 = start2 + pos / 2 - 1;

        if (arr1[pos1] <= arr2[pos2]) {
            return find(arr1, pos1 + 1, end1, arr2, start2, end2, pos - Math.min(pos / 2, len1));
        } else {
            return find(arr1, start1, end1, arr2, pos2 + 1, end2, pos - pos / 2);
        }
    }
}
