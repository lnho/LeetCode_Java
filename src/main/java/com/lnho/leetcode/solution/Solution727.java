package com.lnho.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution727 {
    public String minWindow(String S, String T) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] SArr = S.toCharArray();
        char[] TArr = T.toCharArray();
        for (int i = 0; i < SArr.length; i++) {
            Character c = SArr[i];
            List<Integer> list = map.get(c);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(c, list);
        }
        Character first = TArr[0];
        List<Integer> list = map.get(first);
        if (list == null) return "";
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        for (Integer index : list) {
            Integer min = index;
            for (int i = 1; i < TArr.length; i++) {
                Character c = TArr[i];
                List<Integer> nlist = map.get(c);
                if (nlist == null) return "";
                boolean found = false;
                for (Integer index2 : nlist) {
                    if (index2 > min) {
                        found = true;
                        min = index2;
                        break;
                    }
                }
                if (!found) return minStr;
            }
            if (min - index + 1 < minLen) {
                minStr = S.substring(index, min + 1);
                minLen=min-index+1;
            }
        }
        return minStr;

    }
}
