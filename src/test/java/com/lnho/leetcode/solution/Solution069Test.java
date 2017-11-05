package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution069Test {
    @Test
    public void mySqrt() throws Exception {
        Solution069 s = new Solution069();
        Integer[] test = new Integer[]{0, 1, 4, 8, 2147395600};
        for (Integer input : test) {
            int out1 = s.mySqrt(input);
            int out2 = (int) Math.sqrt(input);
            Assert.assertEquals(out1, out2);
        }
    }
}