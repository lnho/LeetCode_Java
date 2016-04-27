package com.lnho.leetcode.solution;

import java.util.Objects;

public class Solution28 {
    //n是失败的位置（从0开始），也就是匹配成功的长度。
    // substring 其实是到endindex-1处，不包括endindex
    public int[] getShortestDistance(String s) {
        int[] res = new int[s.length()];
        res[0] = 0;
        res[1] = 0;
        for (int i = 2; i < s.length(); i++) {
            res[i] = 0;
            String t = s.substring(0, i);
            System.out.println(t);
            for (int k = i - 1; k > 0; k--) {
                String prefix = t.substring(0, k);
                System.out.println("prefix:" + prefix);
                String suffix = t.substring(i - k);
                System.out.println("suffix:" + suffix);
                if (Objects.equals(prefix, suffix)) {
                    res[i] = k;
                    break;
                }
            }
            System.out.println(res[i]);
        }
        return res;
    }

    public int strStr(String haystack, String needle) {
        int[] next = getShortestDistance(needle);
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
                if(j==0){
                    i++;
                }else{
                j =next[j];}
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        String s = "ababaca";
        System.out.println("res="+solution28.strStr(s, "abac"));
    }
}
