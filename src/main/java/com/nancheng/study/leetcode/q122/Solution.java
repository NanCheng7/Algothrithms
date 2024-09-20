package com.nancheng.study.leetcode.q122;

/**
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/9/20
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}
