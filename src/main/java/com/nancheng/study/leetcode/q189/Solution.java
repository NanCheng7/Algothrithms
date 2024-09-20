package com.nancheng.study.leetcode.q189;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    //#region O(n)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] copy = Arrays.copyOf(nums,nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copy[(copy.length + i - k)% copy.length];
        }
    }
    //#endregion

    //#region O(1)
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    //#endregion
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6,7}; // {6,7,1,2,3,4,5}
        int k = 30;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
