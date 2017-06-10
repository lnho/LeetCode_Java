package com.lnho.leetcode.solution;

import com.lnho.leetcode.common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution098 {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode current, Integer min, Integer max) {
        if (current == null) return true;
        if (current.left != null) {
            int leftMax = (max == null || current.val < max) ? current.val : max;
            if (current.left.val >= leftMax || (min != null && current.left.val <= min))
                return false;
            if (!validate(current.left, min, leftMax))
                return false;
        }
        if (current.right != null) {
            int rightMin = (min == null || current.val > min) ? current.val : min;
            if (current.right.val <= rightMin || (max != null && current.right.val >= max))
                return false;
            if (!validate(current.right, rightMin, max))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-2147483648);
        TreeNode treeNode2 = new TreeNode(2147483647);
        treeNode.right = treeNode2;
        System.out.println(new Solution098().isValidBST(treeNode));
    }
}