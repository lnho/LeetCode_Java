package com.lnho.leetcode.solution;

public class Solution007 {

    public static void main(String[] args) {
        int x = -1563847412;
        long time1 = System.currentTimeMillis();
        System.out.println(new Solution007().reverse(x));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

    public int reverse(int x) {
        boolean flag=false;
        if(x<0){
            flag=true;
            if(-(long)x>Integer.MAX_VALUE){
                return 0;
            }
            x=-x;
        }
        long result=0;
        while(true){
            result=result*10+x%10;
            if(x<10){
                break;
            }
            x/=10;
        }

        if(flag){
            if(-result<Integer.MIN_VALUE){
                return 0;
            }
            return -(int)result;
        }
        if(result>Integer.MAX_VALUE){
            return 0;
        }
        return (int)result;
    }
}
