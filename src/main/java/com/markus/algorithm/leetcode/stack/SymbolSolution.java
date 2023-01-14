package com.markus.algorithm.leetcode.stack;

/**
 * @author: markus
 * @date: 2023/1/14 3:08 PM
 * @Description: 判断字符串符号是否有效
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SymbolSolution {

    static class StackApi<E> {
        private Object[] elements;
        private int capacity;
        private int index;

        public StackApi(int capacity) {
            this.capacity = capacity;
            this.elements = new Object[capacity];
            this.index = -1;
        }

        public boolean isEmpty() {
            return index == -1;
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
    }


    public boolean isValid(String s) {
        try {
            return doAction(s);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean doAction(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        StackApi<Character> stack = new StackApi<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!isJudge(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char left = stack.pop();
                    if (!isMatch(left, ch)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isJudge(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }

    private boolean isMatch(char left, char right) {
        if (left == '{') {
            return right == '}';
        }
        if (left == '(') {
            return right == ')';
        }
        if (left == '[') {
            return right == ']';
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        SymbolSolution symbolSolution = new SymbolSolution();
        System.out.println(symbolSolution.isValid(s));
    }
}
