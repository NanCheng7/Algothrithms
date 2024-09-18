package com.nancheng.study.leetcode.q80;

public class Solution {
    /*
        i遍历
        如果 i ！= val =>  nums[index] = nums[i] val = nums[index] index++
        如果 i == val
            如果 count<2 nums[index] = nums[i] index++
            如果 count>=2 size--
     */
    public int removeDuplicates(int[] nums) {
        int size = nums.length,index = 0,val = nums[index],count = 0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] == val){
               if (count>=2){
                   size--;
               }else {
                   count++;
                   nums[index] = nums[i];
                   index++;
               }
           }else{
               count = 1;
               nums[index] = nums[i];
               val = nums[index];
               index++;
           }
        }
        return size;
    }
}

