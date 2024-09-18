package com.nancheng.study.leetcode.q80;

import org.junit.Test;

public class TestCase {
    @Test
    public void testCase1(){
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int len = new Solution().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
