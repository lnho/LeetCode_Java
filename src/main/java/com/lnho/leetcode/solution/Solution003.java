package com.lnho.leetcode.solution;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by lnhoo on 2017/2/13.
 */
public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        char[] charArr=s.toCharArray();
        int max=0;
        int count=0;
        Queue<Character> queue=new ArrayDeque<>();
        for(int i=0;i<charArr.length;i++){
            Integer last=map.get(charArr[i]);
            if(last==null){
                count++;
                queue.add(charArr[i]);
            }else{
                if(count>max){
                    max=count;
                }
                count=0;
                Character delChar=queue.poll();
                count--;
                while(delChar!=charArr[i]){
                    delChar=queue.poll();
                }
            }
            map.put(charArr[i],i);
        }

        return max;
    }
}
