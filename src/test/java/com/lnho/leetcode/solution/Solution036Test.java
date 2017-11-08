package com.lnho.leetcode.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution036Test {
    @Test
    public void isValidSudoku() throws Exception {
        Solution036 s = new Solution036();
        char[][] board = {
                {'1', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(s.isValidSudoku(board));
    }

}