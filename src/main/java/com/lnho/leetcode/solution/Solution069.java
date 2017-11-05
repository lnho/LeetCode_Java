package com.lnho.leetcode.solution;

public class Solution069 {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int max = 0;
        for (int i = 1; i < x; i++) {
            int res = i * i;
            if (res <= x && res > 0) max = i;
            else break;
        }
        return max;
    }
}
