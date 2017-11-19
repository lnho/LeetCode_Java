package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

public class Solution731Test {
    private static Solution731 s = new Solution731();

    @Test
    public void selfDividingNumbers() throws Exception {
        Assert.assertTrue(s.book(10, 20));
        Assert.assertTrue(s.book(50, 60));
        Assert.assertTrue(s.book(10, 40));
        Assert.assertFalse(s.book(5, 15));
        Assert.assertTrue(s.book(5, 10));
        Assert.assertTrue(s.book(25, 55));
    }

}