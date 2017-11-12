package com.lnho.leetcode.solution;

import java.util.TreeMap;

public class Solution726 {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = count(formula);
        String res = "";
        for (String ch : map.keySet()) {
            Integer val = map.get(ch);
            res += ch;
            if (val > 1) {
                res += val;
            }
        }
        return res;
    }

    private TreeMap<String, Integer> count(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();
        char[] arr = formula.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Character nextc = null;
            if (i < arr.length - 1) {
                nextc = arr[i + 1];
            }
            if (c >= 'A' && c <= 'Z') {
                String ch = "" + c;
                if (nextc != null && nextc >= 'a' && nextc <= 'z') {
                    ch += nextc;
                    i++;
                    if (i < arr.length - 1) {
                        nextc = arr[i + 1];
                    }
                }
                int count = 0;
                while (nextc != null && nextc >= '0' && nextc <= '9') {
                    count = count * 10 + (nextc - '0');
                    i++;
                    if (i < arr.length - 1) {
                        nextc = arr[i + 1];
                    } else {
                        nextc = null;
                    }
                }
                Integer val = map.get(ch);
                if (val == null) {
                    val = 0;
                }
                if (count > 0) {
                    map.put(ch, val + count);
                } else {
                    map.put(ch, val + 1);
                }
            }
            if (c == '(') {
                int left = 1;
                int start = i;
                while (left > 0) {
                    i++;
                    c = arr[i];
                    if (c == '(') {
                        left++;
                    } else if (c == ')') {
                        left--;
                    }

                }
                int end = i;
                String sub = formula.substring(start + 1, end);
                System.out.println(sub);
                TreeMap<String, Integer> map2 = count(sub);
                if (i < arr.length - 1) {
                    nextc = arr[i + 1];
                }
                int count = 0;
                while (nextc != null && nextc >= '0' && nextc <= '9') {
                    count = count * 10 + (nextc - '0');
                    i++;
                    if (i < arr.length - 1) {
                        nextc = arr[i + 1];
                    } else {
                        nextc = null;
                    }
                }
                if (count == 0) {
                    count = 1;
                }
                for (String ch : map2.keySet()) {
                    Integer val = map.get(ch);
                    if (val == null) {
                        val = 0;
                    }
                    val += (map2.get(ch) * count);
                    map.put(ch, val);
                }
            }
        }
        return map;
    }
}