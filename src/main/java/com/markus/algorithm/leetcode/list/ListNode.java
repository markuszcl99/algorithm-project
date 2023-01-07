package com.markus.algorithm.leetcode.list;

/**
 * @author: markus
 * @date: 2023/1/7 6:06 PM
 * @Description: 链表节点 数据结构
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
