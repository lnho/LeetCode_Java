package com.lnho.leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution728Test {
    private static Solution728 s = new Solution728();

    @Test
    public void selfDividingNumbers() throws Exception {
        List<Integer> integers = s.selfDividingNumbers(1, 22);
        int[] actual = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            actual[i] = integers.get(i);
        }
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22};
        Assert.assertArrayEquals(expect, actual);
    }

}