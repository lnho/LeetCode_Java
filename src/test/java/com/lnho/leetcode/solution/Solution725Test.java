package com.lnho.leetcode.solution;

import com.lnho.leetcode.common.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution725Test {
    private static Solution725 s = new Solution725();

    @Test
    public void splitListToParts() throws Exception {
        ListNode root;
        int[] src = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        root = new ListNode(src[0]);
        ListNode cur = root;
        for (int i = 1; i < src.length; i++) {
            cur.next = new ListNode(src[i]);
            cur = cur.next;
        }
        int k = 3;
        ListNode[] res = s.splitListToParts(root, k);
        for (ListNode re : res) {
            ListNode.print(re);
        }
    }

}