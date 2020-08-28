package com.lushwe.algorithm;

import com.alibaba.fastjson.JSON;
import com.lushwe.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：链表反转
 *
 * @author Jack Liu
 * @date 2020-05-29 11:05
 * @since 0.1
 */
public class LinkedListReverse {

    public static void main(String[] args) {

        ListNode<String> node1 = new ListNode<String>("1", null);
        ListNode<String> node2 = new ListNode<String>("2", null);
        ListNode<String> node3 = new ListNode<String>("3", null);
        ListNode<String> node4 = new ListNode<String>("4", null);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        System.out.println(node1);

        ListNode<String> result = reverseOne(node1);

        System.out.println(result);
    }


    /**
     * 方法一
     * @param node
     * @return
     */
    public static ListNode<String> reverseOne(ListNode<String> node) {

        List<ListNode<String>> list = new ArrayList<>();

        ListNode<String> temp = node;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        ListNode<String> head = null;
        ListNode<String> last = null;

        int size = list.size();
        for (int i = 0; i < size; i++) {
            ListNode<String> n = list.get(size - 1 - i);
            if (head == null) {
                head = new ListNode<String>(n.value, null);
                last = head;
            } else {
                last.next = new ListNode<String>(n.value, null);
                last = last.next;
            }
        }

       return head;
    }

    /**
     * 方法二
     * @param node
     * @return
     */
    public static ListNode<String> reverseTwo(ListNode<String> node) {
        ListNode<String> curr = node;
        ListNode<String> next = null;
        ListNode<String> head = null;
        while (curr != null) {
            next = curr.next;
            curr.next = head;
            head = curr;
            curr = next;
        }
        return head;
    }
}
