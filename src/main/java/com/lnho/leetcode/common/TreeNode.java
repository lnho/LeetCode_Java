package com.lnho.leetcode.common;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(String string) {
        TreeNode root = null;
        String[] strArr = getStringArr(string);
        List<TreeNode> needToTraversal = new LinkedList<>();
        for (String s : strArr) {
            if (s.equals("#")) {
            } else {
                int x = Integer.parseInt(s);
                if (root == null) {
                    root = new TreeNode(x);
                    needToTraversal.add(root);
                } else {
                    TreeNode node = new TreeNode(x);
                    needToTraversal.add(node);
                }


            }
        }
    }

    private String[] getStringArr(String string) {
        String substring = string.substring(1, string.length() - 1);
        System.out.println(substring);
        return substring.split(",");
    }
}
