package com.lnho.leetcode.solution;

import com.lnho.leetcode.common.ListNode;

/**
 * Created by Lnho on 2016/3/5.
 */

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode currentNode = head.next;
        ListNode lastOddNode = head;
        lastOddNode.next = null;
        while (currentNode != null) {
            ListNode temp = currentNode.next;
            lastOddNode.next = currentNode;
            currentNode.next = null;

            if (temp == null) {
                break;
            }
            ListNode temp2 = lastOddNode.next;
            lastOddNode.next = temp;
            lastOddNode = lastOddNode.next;
            lastOddNode.next = temp2;
            currentNode = temp.next;
        }
        return head;
    }

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        Solution328 solution328 = new Solution328();
        int[] nodes = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head = null;
        for (int node : nodes) {
            ListNode node1 = new ListNode(node);
            node1.next = head;
            head = node1;
        }
        ListNode.print(head);
        solution328.rotate(nodes, 2);
        ListNode listNode = solution328.oddEvenList(head);
        ListNode.print(listNode);
    }
}
