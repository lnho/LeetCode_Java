package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.nio.channels.SocketChannel;

import static org.junit.Assert.*;

public class Solution727Test {
    private static Solution727 s = new Solution727();

    @Test
    public void test1() throws Exception {
        String str = s.minWindow("abcdebdde", "bde");
        Assert.assertEquals(str, "bcde");
    }

    @Test
    public void test2() throws Exception {
        String str = s.minWindow("cnhczmccqouqadqtmjjzl", "mm");
        Assert.assertEquals(str, "mccqouqadqtm");
    }


}