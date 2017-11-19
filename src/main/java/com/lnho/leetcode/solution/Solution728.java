package com.lnho.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(check(i)) list.add(i);
        }
        return list;
    }
    public boolean check(int input){
        String str=""+input;
        char[] arr=str.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if(c=='0') return false;
            if(c=='1') continue;
            int res=input%(c-'0');
            if(res!=0) return false;
        }
        return true;
    }
}