package com.lushwe.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Jack Liu
 * @date 2019-05-27 17:02
 * @since 1.0
 */
public class Num0003 {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring1("abba"));

    }

    /**
     * 双指针法（HashMap记录）
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> hash = new HashMap<>(s.length());

        int result = 0;

        // chars数组索引位置
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hash.containsKey(c)) {
                int index = hash.get(c);
                if (index >= l) {
                    l = index + 1;
                }
            }
            hash.put(c, i);
            result = Math.max(i - l + 1, result);
        }

        return result;
    }

    /**
     * 双指针法（hash数组记录）
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] hash = new int[128];

        int result = 0;

        int l = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (hash[c] > l) {
                l = hash[c];
            }
            hash[c] = i + 1;

            result = Math.max(i - l + 1, result);
        }

        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int[] hash = new int[128];

        int result = 0;

        // chars数组索引位置
        int l = 0;

        for (int i = 0; i < chars.length; i++) {

            hash[chars[i]]++;

            while (hash[chars[i]] != 1) {
                hash[chars[l]]--;
                l++;
            }

            result = Math.max(i - l + 1, result);
        }

        return result;
    }

    public static int lengthOfLongestSubstring99(String s) {

        if (s == null) {
            return 0;
        }

        int len = 0;

        String temp = "";

        for (int i = 0; i < s.length(); i++) {

            String sub = s.substring(i, i + 1);

            int index = temp.indexOf(sub);

            if (index != -1) {
                temp = temp.substring(index + 1);
            }

            temp += sub;

            if (temp.length() > len) {
                len = temp.length();
            }
        }

        if (len == 0) {
            len = temp.length();
        }

        return len;
    }
}
