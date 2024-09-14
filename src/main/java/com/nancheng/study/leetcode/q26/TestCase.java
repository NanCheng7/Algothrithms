package com.nancheng.study.leetcode.q26;

import org.junit.Test;

import java.util.Arrays;

public class TestCase {
    @Test
    public void testCase1(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
