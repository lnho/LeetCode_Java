package com.lnho.leetcode.common;

/**
 * Created by lnhoo on 2016/4/24.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    public static void print(ListNode listNode){
        while(listNode!=null){
            System.out.print(listNode.val + " ");
            listNode=listNode.next;
        }
        System.out.println();
    }
}
