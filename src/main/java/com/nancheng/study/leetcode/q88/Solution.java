package com.nancheng.study.leetcode.q88;

/**
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/9/12
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }
        for (int i = nums1.length-1; i >= 0; i--) {
            if (m == 0){
                nums1[i] = nums2[n-1];
                n--;
                continue;
            }
            if (n == 0){
                break;
            }
            if (nums1[m-1]>nums2[n-1]){
                nums1[i] = nums1[m-1];
                m--;
            }else {
                nums1[i] = nums2[n-1];
                n--;
            }
        }
    }
}
