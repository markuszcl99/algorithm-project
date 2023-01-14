package com.markus.algorithm.leetcode.stack;

/**
 * @author: markus
 * @date: 2023/1/14 3:26 PM
 * @Description: 最小栈
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MinStack {

    static class StackApi<E> {
        private Object[] elements;
        private int capacity;
        private int index;
        private final static int DEFAULT_SIZE = 10;

        public StackApi() {
            this.capacity = DEFAULT_SIZE;
            this.elements = new Object[capacity];
            this.index = -1;
        }

        public void push(int val) {
            if (index + 1 == capacity) {
                // need dynamic increase capacity
                resize();
            }
            this.elements[++index] = val;
        }

        private void resize() {
            // 2倍扩容
            Object[] newElements = new Object[capacity * 2];
            System.arraycopy(elements, 0, newElements, 0, capacity);
            this.elements = newElements;
            this.capacity = capacity * 2;
        }

        public void pop() {
            if (isEmpty()) {
                return;
            }
            top();
            index--;
        }

        @SuppressWarnings("unchecked")
        public E top() {
            if (isEmpty()) {
                throw new RuntimeException("栈为空！");
            }

            return (E) this.elements[index];
        }

        public boolean isEmpty() {
            return index == -1;
        }
    }

    private StackApi<Integer> originalStack = new StackApi<>();
    private StackApi<Integer> minStack = new StackApi<>();

    public MinStack() {

    }

    public void push(int val) {
        if (!originalStack.isEmpty()) {
            int currentMinVal = minStack.top();
            if (val < currentMinVal) {
                minStack.push(val);
            } else {
                minStack.push(currentMinVal);
            }
        } else {
            minStack.push(val);
        }
        originalStack.push(val);
    }

    public void pop() {
        originalStack.pop();
        minStack.pop();
    }

    public int top() {
        minStack.top();
        return originalStack.top();
    }

    public int getMin() {
        return minStack.top();
    }
}
