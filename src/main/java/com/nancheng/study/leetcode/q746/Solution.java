package com.nancheng.study.leetcode.q746;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/10
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int index = cost[0] > cost[1] ? 0 : 1;
        int count = cost[index];
        return 0;
    }
}
