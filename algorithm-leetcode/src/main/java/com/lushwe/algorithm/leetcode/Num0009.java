package com.lushwe.algorithm.leetcode;

/**
 * 说明：9. 回文数
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author Jack Liu
 * @date 2019-12-06 15:15
 * @since 0.1
 */
public class Num0009 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }


    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        String s = x + "";

        char[] chars = s.toCharArray();

        int max = chars.length / 2;

        for (int i = 0; i < max; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
