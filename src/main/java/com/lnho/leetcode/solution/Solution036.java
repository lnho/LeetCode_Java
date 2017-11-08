package com.lnho.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        List<Map<Character, Integer>> xList = new ArrayList<>();
        List<Map<Character, Integer>> yList = new ArrayList<>();
        List<Map<Character, Integer>> cList = new ArrayList<>();
        for (int x = 0; x < 9; x++) {
            xList.add(new HashMap<>());
            yList.add(new HashMap<>());
            cList.add(new HashMap<>());
        }
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                char val = board[y][x];
                if (val == '.') continue;
                //validate y
                if (yList.get(x).get(val) == null) {
                    yList.get(x).put(val, 1);
                } else {
                    System.out.println("check y:board[" + y + "][" + x + "] can't match");
                    return false;
                }
                //validate x
                if (xList.get(y).get(val) == null) {
                    xList.get(y).put(val, 1);
                } else {
                    System.out.println("check x:board[" + y + "][" + x + "] can't match");
                    return false;
                }
                //validate cube
                int cubeIndex = y / 3 * 3 + x / 3;
                if (cList.get(cubeIndex).get(val) == null) {
                    cList.get(cubeIndex).put(val, 1);
                } else {
                    System.out.println("check cube:board[" + y + "][" + x + "] can't match");
                    return false;
                }
            }
        }
        return true;
    }
}
