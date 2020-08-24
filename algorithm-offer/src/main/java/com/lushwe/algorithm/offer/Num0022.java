package com.lushwe.algorithm.offer;

import com.lushwe.common.ListNode;

/**
 * 说明：剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * leetcode地址：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 *
 * @author Jack Liu
 * @date 2020-08-24 12:56
 * @since 0.1
 */
public class Num0022 {


    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<>(5, null);
        ListNode<Integer> node4 = new ListNode<>(4, node5);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        ListNode<Integer> node1 = new ListNode<>(1, node2);

        System.out.println(node1);

        ListNode result = new Num0022().getKthFromEnd(node1, 2);

        System.out.println(result);
    }

    /**
     * 双指针
     * <p>
     * 一开始两个指针都指向头节点
     * 然后指针2向后移动k个位置
     * 然后两个指针一起向后移动，直接指针2的下一个节点为空
     * 然后指针1指向的节点即为倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1;
    }
}
