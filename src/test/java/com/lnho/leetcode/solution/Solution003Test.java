package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by LINHAO on 2017-2-9.
 */
public class Solution003Test {
    @Test
    public void findMedianSortedArrays() throws Exception {
        Solution003 s = new Solution003();
        int res;
        res = s.lengthOfLongestSubstring("abcdef");
        Assert.assertEquals(res, 6);
        res = s.lengthOfLongestSubstring("abcbc");
        Assert.assertEquals(res, 3);
    }


}