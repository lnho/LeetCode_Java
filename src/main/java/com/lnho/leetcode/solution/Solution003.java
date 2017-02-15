package com.lnho.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lnhoo on 2017/2/13.
 */
public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArr = s.toCharArray();
        int max = 0;
        int count = 0;
        for (int i = 0; i < charArr.length; i++) {
            Integer last = map.get(charArr[i]);
            if (last == null) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                int start=i-count;
                for(int j=start;j<last;j++){
                    map.remove(charArr[j]);
                    count--;
                }
            }
            map.put(charArr[i], i);
        }
        return max;
    }
}
