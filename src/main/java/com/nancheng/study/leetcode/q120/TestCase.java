package com.nancheng.study.leetcode.q120;

import com.nancheng.study.util.ArrayUtil;
import com.nancheng.study.util.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/14
 */
public class TestCase {
    private static final String TEST_CASE1 = "[[-1],[3,2],[1,-2,-1]]";
    private static final String TEST_CASE2 = "[[0,1],[0,0]]";


    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(ArrayUtil.parseNestedList(TEST_CASE1, new TypeToken<List<List<Integer>>>(){}.getType(), Integer::valueOf)));
    }

}


