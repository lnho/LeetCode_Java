package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution724Test {
    private static Solution724 s = new Solution724();

    @Test
    public void pivotIndex() throws Exception {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int res = s.pivotIndex(nums);
        Assert.assertEquals(3, res);
    }

}