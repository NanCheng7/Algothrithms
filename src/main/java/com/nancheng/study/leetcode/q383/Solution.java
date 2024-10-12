package com.nancheng.study.leetcode.q383;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/10/12
 */
public class Solution {


    @Test
    public void test() {
        char a = 'a';
        int[]map = new int[26];
        System.out.println((int) a);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        final int prefix = 97;
        int[]map = new int[26];
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int i = 0;
        while( i < ransomNote.length()) {
            // 遍历字符
            map[ransomNote.charAt(i) - prefix]--;
            map[magazine.charAt(i) - prefix]++;
            i++;
        }
        while (i < magazine.length()) {
            map[ransomNote.charAt(i) - prefix]++;
            i++;
        }
        for (int j : map) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }
}
