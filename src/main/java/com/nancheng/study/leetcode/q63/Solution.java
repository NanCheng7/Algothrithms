package com.nancheng.study.leetcode.q63;


/**
 * @author wangxz
 * @description:
 * @date 2025/3/14
 */
public class Solution {
    // 原数组版
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        boolean obstacles = false;
        // 第一行
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacles = true;
            }
            obstacleGrid[0][i] = !obstacles ? 1 : 0;
        }
        obstacles = false;
        // 第一列
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacles = true;
            }
            obstacleGrid[i][0] = !obstacles ? 1 : 0;
        }
        if (obstacleGrid.length > 1 && obstacleGrid[0].length > 1) {
            for (int i = 1; i < obstacleGrid.length; i++) {
                for (int j = 1; j < obstacleGrid[i].length; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] +obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
    // 滚动数组版 - 单行+单个 M + 1
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            int last = 0;
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = 1;
                    last = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    last = 0;
                    dp[j] = 0;
                    continue;
                }
                if (j == 0) {
                    last = dp[j];
                }else {
                    last = last + dp[j];
                    dp[j] = last;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    last = 0;
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }

}
