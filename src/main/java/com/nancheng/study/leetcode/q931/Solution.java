package com.nancheng.study.leetcode.q931;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/14
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int[] dp = matrix[0];
        for (int i = 1; i < n; i++) {
            int[] temp = Arrays.copyOf(dp,dp.length);
            for (int j = 0; j < n; j++) {
                int min;
                if (j == 0) {
                    min = Math.min(dp[j], dp[j+1]) + matrix[i][j];
                } else if(j == n-1) {
                    min = Math.min(dp[j], dp[j-1]) + matrix[i][j];
                } else {
                    min = Math.min(Math.min(dp[j], dp[j-1]),dp[j+1]) + matrix[i][j];
                }
                temp[j] = min;
            }
            dp = temp;
        }
        Arrays.sort(dp);
        return dp[0];
    }
}
