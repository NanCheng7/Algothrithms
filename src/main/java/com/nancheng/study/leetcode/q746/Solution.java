package com.nancheng.study.leetcode.q746;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/10
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre = 0, cur = 0;
        for ( int i = 2; i <= cost.length; i++)
        {
            int next = Math.min(pre + cost[i - 2], cur + cost[i - 1]);
            pre = cur;
            cur = next;
        }
        return cur;
    }

     public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
              dp[i] = Math.min(dp[i-2],dp[i-1]) + cost[i];
            }
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
