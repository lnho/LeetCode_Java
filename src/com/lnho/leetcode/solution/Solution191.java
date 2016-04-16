package com.lnho.leetcode.solution;

public class Solution191 {

    public static void main(String[] args) {
        int[] nums = new int[40000];
        for (int i = 0; i < 40000; i++) {
            nums[i] = i;
        }
        long time1 = System.currentTimeMillis();
        int num = -2;
        System.out.println(new Solution191().hammingWeight((int) num));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }


    public int hammingWeight(int n) {
        long nlong = 0xFFFFFFFFL & n;
        System.out.println(Long.toHexString(nlong));
        int sum = 0;
        while (nlong > 0) {
            if (nlong % 2 == 1) {
                sum++;
            }
            nlong /= 2;
        }
        return sum;
    }
}
