package com.lushwe.common;

/**
 * 说明：单向链表
 *
 * @author Jack Liu
 * @date 2020-08-24 13:13
 * @since 0.1
 */
public class ListNode<T> {

    public T value;

    public ListNode<T> next;

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.value).append("->");
            node = node.next;
        }
        return sb.substring(0, sb.length() - 2);
    }
}