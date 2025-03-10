package com.nancheng.study.leetcode.q509;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/10
 */
public class Solution {
    // 递归版本
    public int fib(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fib(n - 1) + fib(n - 2);
        }
    }

    // 非递归版本
    public int fib1(int n) {
        int res = 0;
        int sec = 1;
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            return sec;
        }
        for (int i = 0; i < n-1; i++) {
            int temp;
            temp = sec;
            sec = res + sec;
            res = temp;
        }
        return sec;
    }
}
