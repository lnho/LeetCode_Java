package com.lnho.leetcode.solution;

public class Solution001 {

    public static void main(String[] args) {
        //  int a[] = {11, 2, 35, 66, 4, 3, 6, 7, 12, 33, 52, 22, 31, 25, 23};
        //  DualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0);
        //  System.out.println(Arrays.toString(a));
        int n = Integer.MAX_VALUE;
        test1(n);
        test2(n);
    }

    public static boolean canWinNim(int n) {
        return (n & 0b11) != 0;
    }

    public static boolean canWinNim2(int n) {
        return n % 4 != 0;
    }

    public static void test1(int n) {
        Long begin = System.currentTimeMillis();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                canWinNim(i);
                canWinNim(Integer.MAX_VALUE - i);
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("time1:" + (end - begin));
    }

    public static void test2(int n) {
        Long begin = System.currentTimeMillis();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                canWinNim2(i);
                canWinNim2(Integer.MAX_VALUE - i);
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("time2:" + (end - begin));
    }
}
