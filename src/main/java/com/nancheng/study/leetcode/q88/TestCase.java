package com.nancheng.study.leetcode.q88;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/9/12
 */
public class TestCase {
    @Test
    public void test1(){
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int n = 3;
       int[] nums2 = {1,2,3};
       new Solution().merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
