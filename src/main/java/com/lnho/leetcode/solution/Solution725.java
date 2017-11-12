package com.lnho.leetcode.solution;

import com.lnho.leetcode.common.ListNode;

public class Solution725 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int each = len / k;
        int bigger = len % k;
        ListNode[] res = new ListNode[k];
        cur = root;
        ListNode w = null;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < each + 1; j++) {
                if (cur == null) break;
                if (i >= bigger && j == each) {
                    break;
                }
                ListNode newNode = new ListNode(cur.val);
                if (res[i] == null) {
                    res[i] = newNode;
                } else {
                    w.next = newNode;
                }
                w = newNode;
                cur = cur.next;
            }
            if (cur == null) break;
        }

        return res;
    }
}
