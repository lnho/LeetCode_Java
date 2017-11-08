package com.lnho.leetcode.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution037SimpleTest {
    @Test
    public void solveSudoku() throws Exception {
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        Solution037Simple s = new Solution037Simple();
        s.solveSudoku(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(" " + aChar + " ");
            }
            System.out.println();
        }
    }
}