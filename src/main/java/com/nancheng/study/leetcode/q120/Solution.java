package com.nancheng.study.leetcode.q120;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/14
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> temp = new ArrayList<>(dp);
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    temp.set(j,dp.get(j)+triangle.get(i).get(j));
                    continue;
                }
                if (j == triangle.get(i).size() - 2) {
                    temp.set(j,Math.min(dp.get(j-1)+triangle.get(i).get(j),dp.get(j)+triangle.get(i).get(j)));
                    continue;
                }
                if (j == triangle.get(i).size() - 1 ) {
                    temp.add(dp.get(j-1)+triangle.get(i).get(j));
                    continue;
                }
                temp.set(j,Math.min(dp.get(j-1)+triangle.get(i).get(j),dp.get(j)+triangle.get(i).get(j)));
            }
            dp = temp;
        }
        int min = dp.get(0);
        for (Integer i : dp) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
