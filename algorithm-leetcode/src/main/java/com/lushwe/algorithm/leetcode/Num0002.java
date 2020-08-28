package com.lushwe.algorithm.leetcode;

import com.lushwe.common.ListNode;

/**
 * 说明：2. 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @author Jack Liu
 * @date 2019-05-17 09:36
 * @since 1.0
 */
public class Num0002 {


    public static void main(String[] args) {

        ListNode<Integer> node13 = new ListNode<>(1);
//        ListNode<Integer> node12 = new ListNode<>(4, node13);
//        ListNode<Integer> node11 = new ListNode<>(2, node12);

        ListNode<Integer> node23 = new ListNode<>(9);
        ListNode<Integer> node22 = new ListNode<>(9, node23);
//        ListNode<Integer> node21 = new ListNode<>(5, node22);

        System.out.println(node13);
        System.out.println(node22);

        ListNode<Integer> node = new Num0002().addTwoNumbersTwo(node13, node22);

        System.out.println(node);

    }

    /**
     * 方法二
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode<Integer> addTwoNumbersTwo(ListNode<Integer> l1, ListNode l2) {

        ListNode<Integer> first1 = l1;
        ListNode<Integer> first2 = l2;

        ListNode<Integer> first = null;
        ListNode<Integer> last = null;

        // 记录进位
        int carry = 0;

        while (first1 != null || first2 != null || carry != 0) {

            int value = 0;
            if (first1 != null && first2 != null) {
                value = first1.value + first2.value;
            } else if (first1 != null) {
                value = first1.value;
            } else if (first2 != null) {
                value = first2.value;
            }

            value = carry + value;

            ListNode<Integer> next = new ListNode<>(value % 10, null);
            if (first == null) {
                first = next;
            } else {
                last.next = next;
            }
            last = next;

            carry = value / 10;

            if (first1 != null) {
                first1 = first1.next;
            }
            if (first2 != null) {
                first2 = first2.next;
            }
        }

        return first;
    }

    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {

        String str1 = "";
        ListNode<Integer> node1 = l1;
        while (node1 != null) {
            str1 += node1.value;
            node1 = node1.next;
        }
        long value1 = Long.parseLong(str1);

        String str2 = "";
        ListNode<Integer> node2 = l2;
        while (node2 != null) {
            str2 += node2.value;
            node2 = node2.next;
        }
        long value2 = Long.parseLong(str2);

        long value = value1 + value2;

        String str = value + "";

        ListNode<Integer> node = null;
        for (int i = 0; i < str.length(); i++) {
            int v = Integer.parseInt(str.substring(i, i + 1));
            ListNode<Integer> temp = new ListNode<>(v, node);
            node = temp;
        }

        return node;
    }
}
