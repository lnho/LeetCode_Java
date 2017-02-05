package com.lnho.leetcode.solution;

import java.util.Stack;

/**
 * Created by lnhoo on 2017/2/6.
 */
public class Solution388 {
    public int lengthLongestPath(String input) {
        System.out.println(input);
        input += "\n";
        int count = 0;
        boolean isFile = false;
        int depth = 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        char[] charArr = input.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '\n') {
                if (depth != 0) {
                    count += stack.get(depth - 1) + 1;
                }
                while (stack.size() > depth) {
                    stack.pop();
                }
                stack.push(count);
                if (isFile) {
                    if (count > maxLen) {
                        maxLen = count;
                    }
                }
                count = 0;
                depth = 0;
                isFile = false;
            } else if (charArr[i] == '\t') {
                depth++;
            } else {
                if (charArr[i] == '.') {
                    isFile = true;
                }
                count++;
            }
        }
        return maxLen;
    }
}
