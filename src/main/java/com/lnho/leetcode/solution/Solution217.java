package com.lnho.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution217 {

    public static void main(String[] args) {
        int[] nums = new int[40000];
        for (int i = 0; i < 40000; i++) {
            nums[i] = i;
        }
        long time1 = System.currentTimeMillis();
        System.out.println(new Solution217().containsDuplicate(nums));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println(new Solution217().containsDuplicate2(nums));
        long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);
    }

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int containsDuplicate2(int[] nums) {
        int point = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) {
                value = 1;
            } else {
                value++;
            }
            map.put(num, value);
            if (value > point) {
                return value;
            }
        }
        return 0;
    }

    public boolean isPowerOfTwo(int n) {
        return n >= 1 && (n == 1 || (n & 1) == 0 && isPowerOfTwo(n / 2));
    }
}
