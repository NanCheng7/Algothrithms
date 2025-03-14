package com.nancheng.study.leetcode.q198;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
 *
 * @author wangxz
 * @description:
 * @date 2025/3/13
 */
public class Solution {
    /**
     * 分析：
     * 分解子问题，当处于第n个房间时，有两种选择：
     *      进入或者不进入，如果进入n-2个房间时，得到的钱加上进入第n个房间的钱 和 进入第n-1个房间的钱，去两者大者
     *      设立状态数组 dp[n] 表示第n个房间时，能够偷窃到的最高金额
     *      dp[index] = Math.max(dp[index-2] + nums[index], dp[index-1])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length <= 2) {
            if (nums.length == 2) {
                return Math.max(nums[0],nums[1]);
            }
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
