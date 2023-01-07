package com.markus.algorithm.leetcode.list;

import java.util.List;

/**
 * @author: markus
 * @date: 2023/1/7 5:14 PM
 * @Description: 环形链表
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class CycleList {
    /**
     * 链表是否有环
     * 核心思想：快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }

    /**
     * 核心思想：快慢指针制造两次相遇
     * 第一次相遇：f = s + nb and f = 2s ===> s = nb ==> k = nb + a (每次走到环入口需要的步数)
     * 第二次相遇：f = a and s = nb+a ==> 则慢指针直接走到环入口了
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast && fast != null && fast.next != null);
        // 说明链表无环
        if (slow != fast) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode node = new CycleList().detectCycle(head);
        System.out.println(node.val);
    }
}
