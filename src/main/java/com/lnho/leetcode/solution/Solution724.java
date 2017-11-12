package com.lnho.leetcode.solution;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        if(nums.length==0) return -1;
        int right=0;
        for(int i=1;i<nums.length;i++){
            right+=nums[i];
        }
        int left=0;
        for(int i=0;i<nums.length;i++){
            if(left==right){
                return i;
            }
            if(i==nums.length-1){
                return -1;
            }
            left+=nums[i];
            right-=nums[i+1];
        }
        return -1;
    }
}
