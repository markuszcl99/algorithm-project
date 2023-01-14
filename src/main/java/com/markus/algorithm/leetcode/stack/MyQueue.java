package com.markus.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author: markus
 * @date: 2023/1/14 4:02 PM
 * @Description: 用栈实现队列
 * 两个栈，一个用作push栈，栈A，用过用作pop和peek栈，栈B，当操作pop或peek的时候，栈B如果为空，就全量将栈A出栈，然后将元素入栈到栈B中
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MyQueue {

    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (popStack.isEmpty()) {
            inToOut();
        }
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()) {
            inToOut();
        }
        return popStack.peek();
    }

    private void inToOut() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
