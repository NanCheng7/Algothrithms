package com.nancheng.study.leetcode.q238;

/**
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/10/13
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 对nums进行循环，初始化 answer数组,
        // 对其进行初始化,answer用于存放所有的前缀,
        //
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                answer[i] = 1;
            }else {
                answer[i] = nums[i-1] * answer[i - 1];
            }
        }
        int n = 1;
        for(int i = nums.length - 1; i >= 0; i --) {
            if (i == nums.length - 1) {
                answer[i] *= n;
            }else {
                n = nums[i+1] * n;
                answer[i] = answer[i] * n;
            }
        }
        return answer;
    }
}
