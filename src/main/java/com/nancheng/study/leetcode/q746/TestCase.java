package com.nancheng.study.leetcode.q746;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/10
 */
public class TestCase {

    private static final int[] CASE_1 = new int[]{1,100,1,1,1,100,1,1,100,1};
    private static final int[] CASE_2 = new int[]{10,15,20};



    @Test
    public void test1(){
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(CASE_1));
        System.out.println(solution.minCostClimbingStairs(CASE_2));
    }
}
