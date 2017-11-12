package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution726Test {
    private static Solution726 s = new Solution726();
    @Test
    public void countOfAtoms() throws Exception {
        String res = s.countOfAtoms("K4(ON(SO3)2)2");
        Assert.assertEquals("K4N2O14S4",res);
    }

}