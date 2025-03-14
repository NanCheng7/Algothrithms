package com.nancheng.study.leetcode.q221;

/**
 * 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * @author wangxz
 * @description:
 * @date 2025/3/14
 */
public class Solution {
    /**
     * 动态规划：
     *     状态转移方程分析： 对matrix 进行循环(i,j)，当 i = 0 | j = 0 时，dp[i][j] = matrix[i][j]
     *     否则，首先判断
     *          => dp[i-1][j-1] == 0   ==> dp[i][j] = 1
     *          => 否则
     *
     *
     *
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length,n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                  if (matrix[i][j] == '0') {
                      dp[i][j] = 0;
                  } else {
                      if (dp[i-1][j-1] == 0) {
                          dp[i][j] = 1;
                      }else {
                          int deep = dp[i-1][j-1];
                          int cross = 1;
                          for (int depth = 1; depth <= deep; depth++) {
                              if (matrix[i-depth][j] == '0' || matrix[i][j-depth] == '0') {
                                  break;
                              }
                              cross++;
                          }
                          dp[i][j] = cross;
                      }
                  }
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max^2;
    }
}
