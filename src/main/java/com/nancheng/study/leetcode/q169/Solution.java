package com.nancheng.study.leetcode.q169;

public class Solution {
    public int majorityElement(int[] nums) {
        int targetVal = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count ==0 ){
                targetVal = nums[i];
            }if (targetVal == nums[i] ){
                count++;
            }if (targetVal != nums[i]){
                count--;
            }
        }
        return targetVal;
    }
}
