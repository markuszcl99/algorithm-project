package com.markus.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author: markus
 * @date: 2023/1/15 4:28 PM
 * @Description: 棒球比赛
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class BaseballGame {

    Stack<Integer> stack = new Stack<>();

    public int calPoints(String[] operations) {
        if (operations == null || operations.length == 0) {
            return 0;
        }
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int score1 = stack.pop();
                int score2 = stack.pop();
                int cur = score1 + score2;
                stack.push(score2);
                stack.push(score1);
                stack.push(cur);
            } else if (operations[i].equals("D")) {
                int lastScore = stack.peek();
                int cur = 2 * lastScore;
                stack.push(cur);
            } else if (operations[i].equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            count += stack.pop();
        }
        return count;
    }
}
