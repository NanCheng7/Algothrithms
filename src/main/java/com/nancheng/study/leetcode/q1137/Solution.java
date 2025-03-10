package com.nancheng.study.leetcode.q1137;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/10
 */
public class Solution {
    // 超时
    public int tribonacci(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return tribonacci(n - 3) + tribonacci(n - 1) + tribonacci(n - 2);
        }
    }
    // 循环
    public int tribonacci1(int n) {
        int[] record = new int[3];
        record[1] = 1;
        record[2] = 1;
        if (n <= 2) {
            return record[n];
        }
        for (int i = 0; i < n - 2; i++) {
            int t;
            t = record[2];
            record[2] =  record[0] + record[1] + record[2];
            record[0] = record[2] - t - record[0];
            record[1] = t;
        }
        return record[2];
    }
}
