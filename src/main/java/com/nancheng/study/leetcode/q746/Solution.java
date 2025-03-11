package com.nancheng.study.leetcode.q746;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/10
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int l0 = cost[0],l1 = cost[1],res = Math.min(l0,l1);
        int index = 2;
        while (index < cost.length) {
            l0 = l1;
            l1 = res;
            res = Math.min(l0,l1) + cost[index];
            index ++;
        }
        return res;
    }
}
