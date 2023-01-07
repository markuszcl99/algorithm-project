package com.markus.algorithm.leetcode.list;

/**
 * @author: markus
 * @date: 2023/1/7 11:20 AM
 * @Description: 链表反转
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ListReverse {
    static class ListNode {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = currNode.next;
        while (nextNode != null) {
            ListNode cursor = nextNode.next;
            currNode.next = prevNode;
            nextNode.next = currNode;

            prevNode = currNode;
            currNode = nextNode;
            nextNode = cursor;
        }
        return currNode;
    }

    /**
     * 核心思路：找到i，j节点的位置，进行切断形成子链表，子链表执行反转，然后再拼接起来
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left > right) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 1. 先找到left前一节点
        ListNode prevNode = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prevNode = prevNode.next;
        }

        // 2. 找到right以及right后一节点所在的位置
        ListNode rightNode = prevNode;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode currNode = rightNode.next;
        ListNode leftNode = prevNode.next;

        // 3. 切断子链表
        rightNode.next = null;
        prevNode.next = null;
        ListNode reverseNode = reverseList(leftNode);

        // 4. 拼接链表
        prevNode.next = reverseNode;
        leftNode.next = currNode;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        middleTest();
    }

    private static void middleTest() {
        ListReverse reverse = new ListReverse();


        ListNode oneNode = generateNode(1);
        ListNode result = reverse.reverseBetween(oneNode, 1, 1);

        ListNode twoNode = generateNode(2);
        result = reverse.reverseBetween(twoNode, 1, 2);

        ListNode threeNode = generateNode(4);
        result = reverse.reverseBetween(threeNode, 2, 3);

        System.out.println("success");
    }

    private static void simpleTest() {
        ListReverse reverse = new ListReverse();

        ListNode zeroNode = generateNode(0);
        ListNode result = reverse.reverseList(zeroNode);

        ListNode oneNode = generateNode(1);
        result = reverse.reverseList(oneNode);

        ListNode twoNode = generateNode(2);
        result = reverse.reverseList(twoNode);

        ListNode threeNode = generateNode(3);
        result = reverse.reverseList(threeNode);

        System.out.println("success");
    }

    private static ListNode generateNode(int nodeCount) {
        if (nodeCount == 0) {
            return null;
        }
        ListNode head = new ListNode(1);
        ListNode cursor = head;
        for (int i = 1; i < nodeCount; i++) {
            cursor.next = new ListNode(i + 1);
            cursor = cursor.next;
        }
        return head;
    }
}
