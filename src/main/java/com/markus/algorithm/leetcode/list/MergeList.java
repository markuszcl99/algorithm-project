package com.markus.algorithm.leetcode.list;

/**
 * @author: markus
 * @date: 2023/1/7 6:05 PM
 * @Description: 合并链表
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummyNode = new ListNode(-999);
        ListNode cursor = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cursor.next = list1;
                list1 = list1.next;
            } else {
                cursor.next = list2;
                list2 = list2.next;
            }
            cursor = cursor.next;
        }
        if (list1 != null) {
            cursor.next = list1;
        }
        if (list2 != null) {
            cursor.next = list2;
        }
        return dummyNode.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int len = lists.length;
        ListNode dummy = null;
        for (int i = 0; i < len; i++) {
            dummy = mergeTwoLists(dummy, lists[i]);
        }
        return dummy;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] lists = {head1, head2, head3};
        MergeList mergeList = new MergeList();
        ListNode result = mergeList.mergeKLists(lists);
        System.out.println(result);
    }

}
