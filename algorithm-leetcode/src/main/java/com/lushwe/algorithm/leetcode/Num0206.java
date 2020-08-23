package com.lushwe.algorithm.leetcode;

/**
 * 说明：反转链表
 * <p>
 * leetcode地址：https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author Shiwei Liu
 * @date 2020-08-23 18:21
 * @since 0.1
 */
public class Num0206 {

    public static void main(String[] args) {

        ListNode<Integer> node5 = new ListNode<>(5, null);
        ListNode<Integer> node4 = new ListNode<>(4, node5);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        ListNode<Integer> node1 = new ListNode<>(1, node2);

        System.out.println("=====");
        ListNode<Integer> temp = node1;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

        ListNode<Integer> node = reverseListNode(node1);

        System.out.println("=====");
        temp = node;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }


    public static <T> ListNode<T> reverseListNode(ListNode<T> head) {

        ListNode<T> prev = null;
        ListNode<T> curr = head;

        while (curr != null) {
            ListNode<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    static class ListNode<T> {

        T value;

        ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
