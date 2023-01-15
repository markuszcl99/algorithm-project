package com.markus.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: markus
 * @date: 2023/1/15 4:52 PM
 * @Description: 下一个更大的元素
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class NextGreaterNumber {

    public int[] nextGreaterElementV1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Stack<Integer> rightStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        int greaterElement = -1;
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            rightStack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            while (!tempStack.isEmpty()) {
                rightStack.push(tempStack.pop());
            }
            while (!rightStack.isEmpty()) {
                int ele = rightStack.pop();
                tempStack.push(ele);
                if (ele > nums1[i]) {
                    greaterElement = ele;
                } else if (ele == nums1[i]) {
                    result[i] = greaterElement;
                }
            }
            greaterElement = -1;
        }
        return result;
    }

    /**
     * 单调栈+哈希表 思想
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> numberToGreater = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            numberToGreater.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            if (stack.isEmpty() || stack.peek() > nums2[i]) {
                stack.push(nums2[i]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = numberToGreater.get(nums1[i]) == null ? -1 : numberToGreater.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterNumber demo = new NextGreaterNumber();
        int[] nums1 = {3, 1, 5, 7, 9, 2, 6};
        int[] nums2 = {1, 2, 3, 5, 6, 7, 9, 11};
        int[] result = demo.nextGreaterElement(nums1, nums2);
        for (int i : result) {
            System.out.printf(i + " ");
        }
    }
}
