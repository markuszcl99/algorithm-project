package com.markus.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author: markus
 * @date: 2023/1/14 4:47 PM
 * @Description: 包含退格的字符串符号判断是否相等
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SymbolSolutionV2 {
    private Stack<Character> left = new Stack<>();
    private Stack<Character> right = new Stack<>();

    /**
     * 时间复杂度O(n+m)
     * 空间复杂度O(n+m)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompareV1(String s, String t) {
        if (!validString(s) || !validString(t)) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                pop(left);
            } else {
                left.push(ch);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch == '#') {
                pop(right);
            } else {
                right.push(ch);
            }
        }
        while (!left.isEmpty() && !right.isEmpty()) {
            char leftCh = left.pop();
            char rightCh = right.pop();
            if (leftCh != rightCh) {
                return false;
            }
        }
        return left.isEmpty() && right.isEmpty();
    }

    private void pop(Stack<Character> stack) {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    /**
     * 利用双指针
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        if (!validString(s) || !validString(t)) {
            return false;
        }
        int sCursor = s.length() - 1;
        int tCursor = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (sCursor >= 0 || tCursor >= 0) {
            while (sCursor >= 0) {
                if (s.charAt(sCursor) == '#') {
                    skipS++;
                    sCursor--;
                } else if (skipS > 0) {
                    skipS--;
                    sCursor--;
                } else {
                    break;
                }
            }
            while (tCursor >= 0) {
                if (t.charAt(tCursor) == '#') {
                    skipT++;
                    tCursor--;
                } else if (skipT > 0) {
                    skipT--;
                    tCursor--;
                } else {
                    break;
                }
            }
            if (sCursor >= 0 && tCursor >= 0) {
                if (s.charAt(sCursor) != t.charAt(tCursor)) {
                    return false;
                }
            } else {
                if (sCursor >= 0 || tCursor >= 0) {
                    return false;
                }
            }
            sCursor--;
            tCursor--;
        }
        return true;
    }

    private boolean validString(String s) {
        return s != null && s.length() != 0;
    }

    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";

        SymbolSolutionV2 demo = new SymbolSolutionV2();
        System.out.println(demo.backspaceCompare(s, t));
    }

}
