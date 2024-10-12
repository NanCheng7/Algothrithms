package com.nancheng.study.leetcode.q383;

import org.junit.Test;

/**
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/10/12
 */
public class Solution {


    @Test
    public void test() {
        char a = 'a';
        System.out.println((int) a);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        final int prefix = 97;
        int[][] map = new int[2][26];
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for (int i = 0; i < magazine.length(); i++) {

        }
        return true;
    }
}
