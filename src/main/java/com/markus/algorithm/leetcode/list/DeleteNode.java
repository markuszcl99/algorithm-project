package com.markus.algorithm.leetcode.list;

/**
 * @author: markus
 * @date: 2023/1/7 10:21 PM
 * @Description: 删除链表中倒数第K个节点
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DeleteNode {
    /**
     * 该题目有三种解法：
     * first: 先统计链表长度，再计算要删除的节点所处的正数个位置，需要再次遍历然后删除（时间复杂度为O(L) 空间复杂度为O(1)）
     * second: 利用栈的思想解决问题，将所有的节点从前到后都压入栈中，然后弹出N+1个节点，然后历史倒数第N+1的节点删除倒数第N个节点（时间复杂度为O(L) 空间复杂度为O(L)）
     * third: 利用快慢指针思想，快指针先于慢指针n步，那么到快指针到尾结点的时候，那么慢指针则是倒数第N+1个节点，那么倒数第N个节点则可以被删除了（时间复杂度为O(L) 空间复杂度为O(1)）(比方法一更高效)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        ListNode dummyNode = new ListNode(-999);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
