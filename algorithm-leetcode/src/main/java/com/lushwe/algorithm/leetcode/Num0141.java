package com.lushwe.algorithm.leetcode;

import com.lushwe.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 说明：141. 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 *
 * @author Jack Liu
 * @date 2019-12-24 13:58
 * @since 0.1
 */
public class Num0141 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

//        node6.next = node1;


        System.out.println(hasCycleOne(node1));

    }


    /**
     * 双指针法
     * <p>
     * 一个指针每次前进两步
     * 一个指针每次前进一步
     * <p>
     * 如果链表有环，那么每次前进两步的指针一定能追上每次前进一步的指针
     * 假设，现在快追上了，那么前进两步的指针与前进一步的指针必定能在下一个节点相遇
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public static boolean hasCycleTwo(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode l1 = head;
        ListNode l2 = head.next;

        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }

        return false;
    }

    /**
     * 哈希法
     * <p>
     * 遍历链表，判断节点在哈希表是否存在，存在则有环，退出；
     * 不存在则暂时还没有环，将节点加入哈希表，直到链表尾部，如果哈希表仍然不存在，则表示没有环
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     * @return
     */
    public static boolean hasCycleOne(ListNode head) {
        Set<ListNode> hash = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (hash.contains(node)) {
                return true;
            }
            hash.add(node);
            node = node.next;
        }
        return false;
    }

}
