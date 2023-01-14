package com.markus.algorithm.leetcode.stack;

/**
 * @author: markus
 * @date: 2023/1/14 2:52 PM
 * @Description: 实现栈的操作
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class StackApi<E> {
    private Object[] elements;
    private int capacity;
    private int index;

    public StackApi(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.index = -1;
    }

    public void push(E e) {
        if (index + 1 == capacity) {
            throw new UnsupportedOperationException("容量不足!");
        }
        this.elements[++index] = e;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (index == -1) {
            throw new UnsupportedOperationException("栈为空");
        }

        E e = (E) this.elements[index--];
        return e;
    }

    public static void main(String[] args) {
        StackApi<Integer> stack = new StackApi<>(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // 容量不足
//        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        // 栈为空
//        System.out.println(stack.pop());
    }
}
