package com.markus.algorithm.leetcode.stack;

import com.sun.istack.internal.Nullable;

import java.util.Stack;

/**
 * @author: markus
 * @date: 2023/1/15 5:14 PM
 * @Description: 单调栈
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MonotonousStack {
    /**
     * 单调递增栈 即栈底 到 栈顶元素数据从大到小
     *
     * @param nums
     * @return
     */
    @Nullable
    public Stack<Integer> increase(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 1. 栈为空或者栈顶元素比当前值大
            if (stack.isEmpty() || stack.peek() > nums[i]) {
                // 直接入栈
                stack.push(nums[i]);
            } else {
                // 2. 当前栈不为空或者栈底栈顶元素比当前值小
                Stack<Integer> temp = new Stack<>();// 临时栈
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    temp.push(stack.pop());
                }
                stack.push(nums[i]);
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        int nums[] = {10, 3, 7, 4, 12};
        Stack<Integer> stack = new MonotonousStack().increase(nums);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
