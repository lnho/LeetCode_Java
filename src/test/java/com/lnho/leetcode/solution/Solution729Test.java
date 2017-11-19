package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Solution729Test {
    private static Solution729 s = new Solution729();

    @Test
    public void selfDividingNumbers() throws Exception {
        Assert.assertTrue(s.book(10, 20));
        Assert.assertFalse(s.book(15, 25));
        Assert.assertTrue(s.book(20, 30));
    }

}