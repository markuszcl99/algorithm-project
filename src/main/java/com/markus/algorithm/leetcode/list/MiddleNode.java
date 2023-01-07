package com.markus.algorithm.leetcode.list;

/**
 * @author: markus
 * @date: 2023/1/7 11:15 PM
 * @Description: 返回链表的中间节点
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        int len = getLength(head);
        if (len == 0 || len == 1) {
            return len == 0 ? null : head;
        }
        int middle = len / 2;
        ListNode cursor = head;
        for (int i = 0; i < middle; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int i = 1;
        ListNode cursor = head;
        while (cursor.next != null) {
            i++;
            cursor = cursor.next;
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
