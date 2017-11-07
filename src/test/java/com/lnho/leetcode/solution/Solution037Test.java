package com.lnho.leetcode.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution037Test {
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
        Solution037 s = new Solution037();
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(" " + aChar + " ");
            }
            System.out.println();
        }
        s.solveSudoku(board);
//        s.getCube(1);
        s.check();
//        for (char[] chars : board) {
//            for (char aChar : chars) {
//                System.out.print(" "+aChar+" ");
//            }
//            System.out.println();
//        }
    }
    @Test
    public void solveSudokuEasy() throws Exception {
        char[][] board = {
                {'.', '.', '.', '9', '7', '.', '8', '5', '.'},
                {'9', '.', '.', '.', '.', '5', '.', '6', '4'},
                {'3', '.', '.', '4', '.', '.', '7', '.', '9'},
                {'.', '.', '9', '6', '3', '8', '.', '.', '.'},
                {'6', '8', '3', '.', '4', '2', '.', '.', '5'},
                {'.', '2', '4', '.', '9', '.', '3', '.', '.'},
                {'7', '.', '1', '.', '.', '9', '6', '3', '.'},
                {'.', '3', '.', '7', '.', '4', '.', '9', '.'},
                {'8', '9', '5', '.', '.', '.', '1', '.', '7'}};
        Solution037 s = new Solution037();
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(" " + aChar + " ");
            }
            System.out.println();
        }
        s.solveSudoku(board);
//        s.getCube(1);
        s.check();
//        for (char[] chars : board) {
//            for (char aChar : chars) {
//                System.out.print(" "+aChar+" ");
//            }
//            System.out.println();
//        }
    }

    @Test
    public void solveSudokuHard() throws Exception {
        char[][] board = {
                {'.', '4', '.', '.', '.', '.', '.', '.', '9'},
                {'1', '5', '3', '.', '8', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '7', '3', '1', '.'},
                {'.', '.', '4', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '4', '8', '5', '.', '.'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '6', '.', '.', '.', '.', '5', '.'},
                {'5', '.', '1', '.', '.', '.', '.', '4', '8'},
                {'.', '.', '.', '2', '1', '5', '6', '.', '.'}};
        Solution037 s = new Solution037();
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(" " + aChar + " ");
            }
            System.out.println();
        }
        s.solveSudoku(board);
        s.check();
    }

    @Test
    public void solveSudokuMedium() throws Exception {
        char[][] board = {
                {'.', '6', '2', '3', '1', '7', '5', '4', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '6', '2'},
                {'9', '5', '4', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '9', '.', '.', '6'},
                {'4', '.', '.', '8', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '9', '5', '4'},
                {'.', '3', '.', '9', '5', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '6', '.', '3', '1'},
                {'6', '2', '8', '1', '7', '3', '.', '.', '.'}};
        Solution037 s = new Solution037();
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(" " + aChar + " ");
            }
            System.out.println();
        }
        s.solveSudoku(board);
        s.check();
    }

}