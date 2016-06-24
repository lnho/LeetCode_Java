package com.lnho.leetcode.solution;

/**
 * Created by Administrator on 2016-06-24.
 */
public class Solution344 {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        char temp;
        for (int i = 0; i < len / 2; i++) {
            temp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = temp;
        }
        return new String(chars);
    }
}
