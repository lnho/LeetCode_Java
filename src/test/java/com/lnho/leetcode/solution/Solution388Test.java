package com.lnho.leetcode.solution;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lnhoo on 2017/2/6.
 */
public class Solution388Test {
    @Test
    public void lengthLongestPath() throws Exception {
        Solution388 s = new Solution388();
        int k = s.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        System.out.println(k);
    }

}