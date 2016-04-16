package com.lnho.leetcode.solution;

import com.lnho.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution107 {

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        TreeNode root=new TreeNode("[3,9,20,#,#,15,7]");
        new Solution107().levelOrderBottom(root);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = levelOrder(root);
        Collections.reverse(result);
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> one = new ArrayList<>();
        one.add(root.val);
        result.add(one);
        List<List<Integer>> left = levelOrder(root.left);
        List<List<Integer>> right = levelOrder(root.right);
        for (int i = 0; i < left.size() || i < right.size(); i++) {
            List<Integer> item = new ArrayList<>();
            if (i < left.size()) {
                for (Integer k : left.get(i)) {
                    item.add(k);
                }
            }
            if (i < right.size()) {
                for (Integer k : right.get(i)) {
                    item.add(k);
                }
            }
            result.add(item);
        }
        Collections.reverse(result);
        return result;
    }
}
