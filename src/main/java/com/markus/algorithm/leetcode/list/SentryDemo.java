package com.markus.algorithm.leetcode.list;

/**
 * @author: markus
 * @date: 2023/1/7 10:52 AM
 * @Description: 编写链表技巧三：利用哨兵简化实现难度
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SentryDemo {
    public static void main(String[] args) {
        char[] ch = {4, 2, 3, 5, 9, 6};
        int n = 6;
        char key = 6;
        System.out.println(demo1(ch,n,key));
        System.out.println(demo2(ch,n,key));
    }

    private static int demo1(char[] ch, int n, char key) {
        if (ch == null || n <= 0) {
            return -1;
        }

        int i = 0;
        while (i < n) {
            if (ch[i] == key) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int demo2(char[] ch, int n, char key) {
        if (ch == null || n <= 0) {
            return -1;
        }
        // 先判断 ch[n-1] == key ?
        if (ch[n - 1] == key) {
            return n - 1;
        }

        // ch[n-1] != key ，我们可以将这个位置作为哨兵
        // 记录n-1 位置 的值，后续再替换回来
        char temp = ch[n - 1];
        ch[n - 1] = key;
        int i = 0;
        // 比demo1中的循环少了一次 i < n 的执行
        while (ch[i] != key) {
            i++;
        }
        ch[n - 1] = temp;
        if (i == n - 1) {
            // 说明不匹配
            return -1;
        }
        return i;
    }
}
