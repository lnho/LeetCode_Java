package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-06-24.
 */
public class Solution344Test {
    private Solution344 solution=new Solution344();
    @Test
    public void reverseString() throws Exception {
        String res=solution.reverseString("hello");
        Assert.assertEquals("olleh",res);
    }

}