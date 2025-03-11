package com.nancheng.study.leetcode.q746;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/10
 */
public class TestCase {
    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] a = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(solution.minCostClimbingStairs(a));
    }
}
