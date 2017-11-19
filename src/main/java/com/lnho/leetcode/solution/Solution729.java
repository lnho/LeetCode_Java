package com.lnho.leetcode.solution;

import java.util.TreeMap;

class Solution729 {
    private TreeMap<Integer, Integer> bookMap = new TreeMap<>();

    public boolean book(int start, int end) {

        for(Integer key:bookMap.keySet()){
            Integer value=bookMap.get(key);
            if(key<=start&&value>start) return false;
            if(key>=start&&key<end) return false;
        }
        bookMap.put(start,end);
        return true;
    }
}