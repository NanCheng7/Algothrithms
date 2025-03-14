package com.nancheng.study.leetcode.q63;

import com.nancheng.study.util.ArrayUtil;
import org.junit.Test;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/14
 */
public class TestCase {
    private static final String TEST_CASE1 = "[[0,0,0,0],[0,1,0,0],[0,0,0,0],[0,0,1,0],[0,0,0,0]]";
    private static final String TEST_CASE2 = "[[0,1],[0,0]]";

    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles1((int[][]) ArrayUtil.convertArray(ArrayUtil.build2DArrayFromStrByCommaSplit(TEST_CASE1, Integer.class), int.class)));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles1((int[][]) ArrayUtil.convertArray(ArrayUtil.build2DArrayFromStrByCommaSplit(TEST_CASE2, Integer.class), int.class)));
    }
}
