package com.lnho.leetcode.solution;

import com.lnho.leetcode.common.TestUtil;
import org.junit.Test;

/**
 * Created by Administrator on 2016-05-04.
 */
public class Solution015Test {
    private static Solution015 solution = new Solution015();

    @Test
    public void threeSum() throws Exception {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        TestUtil.print(solution.threeSum2(nums));
        int[] nums2 = {-1, 0, 1, 2, 0, -0};
        TestUtil.print(solution.threeSum2(nums2));
        int[] nums3 = {-1, 0, 1, 0};
        TestUtil.print(solution.threeSum2(nums3));
    }
}