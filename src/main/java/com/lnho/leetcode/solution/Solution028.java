package com.lnho.leetcode.solution;

import java.util.Arrays;
import java.util.Objects;

public class Solution028 {
    /**
     * 低效的Next指针算法
     *
     * @param s
     * @return
     */
    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        if (s.length() == 1) {
            return next;
        }
        next[1] = 0;
        for (int i = 2; i < s.length(); i++) {
            next[i] = 0;
            String t = s.substring(0, i);
            //System.out.println(t);
            for (int k = i - 1; k > 0; k--) {
                String prefix = t.substring(0, k);
                String suffix = t.substring(i - k);
                if (Objects.equals(prefix, suffix)) {
                    next[i] = k;
                    break;
                }
            }
        }
        System.out.println("next1:" + Arrays.toString(next));
        return next;
    }

    /**
     * 普通KMP的Next指针算法
     *
     * @param s
     * @return
     */
    public int[] getNext2(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        if (s.length() == 1) {
            return next;
        }
        next[1] = 0;
        int i = 1;//代表前一个元素
        int j = 0;//代表前一个元素对应的next值
        while (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                i++;
                next[i] = j;
            } else {
                if (j == 0) {
                    i++;
                    next[i] = 0;
                } else {
                    j = next[j];
                }
            }
        }
        System.out.println("next2:" + Arrays.toString(next));
        return next;
    }

    /**
     * 改进的KMP的Next指针算法
     *
     * @param s
     * @return
     */
    public int[] getNext3(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        if (s.length() == 1) {
            return next;
        }
        next[1] = 0;
        int i = 1;//代表前一个元素
        int j = 0;//代表前一个元素对应的next值
        while (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                i++;
                if (s.charAt(i) == s.charAt(j)) {
                    next[i] = next[j - 1];
                } else {
                    next[i] = j;
                }
            } else {
                if (j == 0) {
                    i++;
                    next[i] = 0;
                } else {
                    j = next[j];
                }
            }
        }
        System.out.println("next3:" + Arrays.toString(next));
        return next;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNext3(needle);
        int index = -1;
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j];
                }
            }
        }
        return index;
    }
}
