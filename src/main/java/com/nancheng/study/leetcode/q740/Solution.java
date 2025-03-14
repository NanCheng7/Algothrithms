package com.nancheng.study.leetcode.q740;


/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *
 *
 * @author wangxz
 * @description:
 * @date 2025/3/13
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max,num);
        }
        int[] sum = new int[max+1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        if (nums.length <= 2) {
            if (nums.length == 2) {
                return Math.max(nums[0],nums[1]);
            }
            return nums[0];
        }
        int last = 0, now = 0;
        last = nums[0];
        now = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = now;
            now = Math.max(last + nums[i], now);
            last = temp;
        }
        return now;
    }
}
