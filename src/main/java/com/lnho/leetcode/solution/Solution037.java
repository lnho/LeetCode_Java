package com.lnho.leetcode.solution;

import java.util.*;

public class Solution037 {
    private char[][] board;
    private Map<Integer, List<Character>> unsolve = new TreeMap<>();
    private int round = 0;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int y = 0; y < board.length; y++) {
            char[] chars = board[y];
            for (int x = 0; x < chars.length; x++) {
                char aChar = chars[x];
                if (aChar == '.') {
                    unsolve.put(y * 9 + x, new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')));
                }
            }
        }
        System.out.println();
    }

    public void check() {
        round++;
        System.out.println("==========================[Start round " + round + "]==============================");
        boolean change = false;
//        System.out.println("处理前：");
//        for (Integer integer : unsolve.keySet()) {
//            List<Character> integers = unsolve.get(integer);
//            System.out.println(integer + ":" + integers.toString());
//        }
        for (Integer integer : unsolve.keySet()) {
            boolean thisChange = false;
            List<Character> resX = checkX(integer);
            if (resX.size() > 0) {
                thisChange = true;
            }
            List<Character> resY = checkY(integer);
            if (resY.size() > 0) {
                thisChange = true;
            }
            List<Character> resC = checkCube(integer);
            if (resC.size() > 0) {
                thisChange = true;
            }
            if (thisChange) {
                change = true;
                System.out.println(integer + " removed:" + resX + resY + resC);
            }
        }
        List<Integer> needRemove = new ArrayList<>();
        for (Integer integer : unsolve.keySet()) {
            List<Character> integers = unsolve.get(integer);
//            System.out.println(integer + ":" + integers.toString());
            if (integers.size() == 1) {
                System.out.println("new num solved:" + integer);
                board[integer / 9][integer % 9] = integers.get(0);
                needRemove.add(integer);
            }
        }
        for (Integer integer : needRemove) {
            unsolve.remove(integer);
        }
        //进行摒除法
        for (char i = '1'; i <= '9'; i++) {
            boolean thisChange = checkNumX(i);
            if (thisChange) change = true;
        }
        if (change) {
            check();
        } else {
            System.out.println("目前结果：");
            for (Integer integer : unsolve.keySet()) {
                List<Character> integers = unsolve.get(integer);
                System.out.println(integer + ":" + integers.toString());
            }
            for (char[] chars : board) {
                for (char aChar : chars) {
                    System.out.print(" " + aChar + " ");
                }
                System.out.println();
            }

        }
    }

    public List<Character> checkX(int n) {
        int getY = n / 9;
        List<Character> exist = new ArrayList<>();
        List<Character> removed = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            char c = board[getY][i];
            if (c != '.') {
                exist.add(c);
            }
        }
        List<Character> integers = unsolve.get(n);
        for (Character character : exist) {
            if (integers.remove(character)) {
                removed.add(character);
            }
        }
//        System.out.println(n + ":" + integers);
        return removed;
    }

    public List<Character> checkY(int n) {
        int getX = n % 9;
        List<Character> exist = new ArrayList<>();
        List<Character> removed = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            char c = board[i][getX];
            if (c != '.') {
                exist.add(c);
            }
        }
        List<Character> integers = unsolve.get(n);
        for (Character character : exist) {
            if (integers.remove(character)) {
                removed.add(character);
            }
        }
//        System.out.println(n + ":" + integers);
        return removed;
    }

    public List<Character> checkCube(int n) {
        int startY = n / 9 / 3 * 3;
        int startX = (n % 9) / 3 * 3;
        List<Character> exist = new ArrayList<>();
        List<Character> removed = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                Character c = board[startY + j][startX + k];
                if (c != '.') {
                    exist.add(c);
                }
            }
        }
        List<Character> integers = unsolve.get(n);
        for (Character character : exist) {
            if (integers.remove(character)) {
                removed.add(character);
            }
        }
//        System.out.println(n + ":" + integers);
        return removed;
    }

    public boolean checkNumX(char c) {
        int count = 0;
        boolean change = false;
        for (int y = 0; y < 9; y++) {
            boolean found = false;
            List<Integer> poss = new ArrayList<>();
            for (int x = 0; x < 9; x++) {
                if (board[y][x] == c) {
                    found = true;
                    break;
                }
                if (board[y][x] == '.') {
                    int num = y * 9 + x;
                    List<Character> characters = unsolve.get(num);
                    if (characters.contains(c)) {
                        poss.add(num);
                    }
                }
            }
            if (found) {
                count++;
            } else {
                System.out.println("check " + c + " in line " + y + ",possible num is:" + poss);
                if (poss.size() == 1) {
                    int integer = poss.get(0);
                    System.out.println("new num solved:" + c);
                    board[integer / 9][integer % 9] = c;
                    unsolve.remove(integer);
                    change = true;
                }
            }
        }
        System.out.println("数字" + c + "已解出:" + count);
        return change;
    }
}
