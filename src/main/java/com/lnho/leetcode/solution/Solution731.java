package com.lnho.leetcode.solution;

import java.util.TreeMap;

class Solution731 {
    private TreeMap<Integer, Integer> bookMap = new TreeMap<>();
    private TreeMap<Integer, Integer> dBookMap = new TreeMap<>();

    public boolean book(int start, int end) {
        //判断triple
        for(Integer key:dBookMap.keySet()){
            if(end<key) break;
            Integer value=dBookMap.get(key);
            if(key<=start&&value>start) return false;
            if(key>=start&&key<end) return false;
        }
        //判断double
        TreeMap<Integer, Integer> res =check(bookMap,start,end);
        for(Integer key:res.keySet()){
            Integer value=res.get(key);
            dBookMap.put(key,value);
//            System.out.println("dBookMap:"+key+":"+value);
        }
        bookMap.merge(start, end, (a, b) -> b > a ? b : a);
        //System.out.println("dBookMap:"+start+":"+end);
        return true;
    }
    private TreeMap<Integer,Integer> check(TreeMap<Integer, Integer> map, int start, int end){
        TreeMap<Integer, Integer> res = new TreeMap<>();
        for(Integer key:map.keySet()){
            if(end<key) break;
            Integer value=map.get(key);
            if(key<=start&&value>start) {
                res.put(start,end<value?end:value);
            }
            if(key>=start&&key<end) {
                res.put(key,end<value?end:value);
            }
        }
        return res;
    }
}