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
        return validate(root, null);
    }

    public boolean validate(TreeNode current, TreeNode parent) {
        if (current == null) return true;
        if (current.left != null && (current.left.val >= current.val || (parent != null && current.left.val <= parent.val)))
            return false;
        if (current.right != null && (current.right.val <= current.val || (parent != null && current.right.val >= parent.val)))
            return false;
        if (validate(current.left, current) && validate(current.right, current)) return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode.left = treeNode2;
        System.out.println(new Solution098().isValidBST(treeNode));
    }
}