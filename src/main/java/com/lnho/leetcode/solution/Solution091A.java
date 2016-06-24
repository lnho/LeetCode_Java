package com.lnho.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution091A {
    private static Map<String, Integer> resMap = new HashMap<>();

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0) return 0;
        //假设字符串无限长，例如ABXXXXXXX...,我们只关注前2位
        //当A单独解析时，可能的解析方式有numDecodings(BXXXXXXX...)种
        //当A和B组合解析时，可能的解析方式有numDecodings(XXXXXXX...)种
        //最后的结果，是上述2种情况的和。
        Integer res1 = 0;
        Integer res2 = 0;
        if (len >= 1) {
            char ch = chars[0];
            if (ch == '0') {
                return 0;
            } else {
                if (len == 1) {
                    res1 = 1;
                } else {
                    String substring = s.substring(1);
                    res1 = resMap.get(substring);
                    if (res1 == null) {
                        res1 = numDecodings(substring);
                        resMap.put(substring, res1);
                    }
                }
            }
            if (len >= 2) {
                if (ch == '1') {
                    if (len == 2) {
                        res2 = 1;
                    } else {
                        res2 = numDecodings(s.substring(2));
                    }
                } else if (ch == '2') {
                    if (chars[1] >= '0' && chars[1] <= '6') {
                        if (len == 2) {
                            res2 = 1;
                        } else {
                            String substring = s.substring(2);
                            res2 = resMap.get(substring);
                            if (res2 == null) {
                                res2 = numDecodings(substring);
                                resMap.put(substring, res2);
                            }
                        }
                    }
                }
            }
        }
        return res1 + res2;
    }
}
