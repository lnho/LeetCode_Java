package com.lnho.leetcode.solution;

import java.util.*;

public class Solution037Simple {
    private final int SUCCESS = 1;
    private final int FAIL = -1;
    private final int UNDONE = 0;

    public void solveSudoku(char[][] board) {
        recursion(board, initUnsolveMap(board));
    }

    private int solve(char[][] board, Map<Integer, List<Character>> unsolve) {
        boolean change = false;
        //进行唯一余数法
        for (Integer integer : unsolve.keySet()) {
            boolean thisChange = false;
            List<Character> resX = checkX(board, unsolve, integer);
            if (resX.size() > 0) {
                thisChange = true;
            }
            List<Character> resY = checkY(board, unsolve, integer);
            if (resY.size() > 0) {
                thisChange = true;
            }
            List<Character> resC = checkCube(board, unsolve, integer);
            if (resC.size() > 0) {
                thisChange = true;
            }
            if (thisChange) {
                change = true;
            }
        }
        List<Integer> needRemove = new ArrayList<>();
        for (Integer integer : unsolve.keySet()) {
            List<Character> integers = unsolve.get(integer);
            if (integers.size() == 1) {
                board[integer / 9][integer % 9] = integers.get(0);
                needRemove.add(integer);
            }
            if (integers.size() == 0) {
                return FAIL;
            }
        }
        for (Integer integer : needRemove) {
            unsolve.remove(integer);
        }
        //进行摒除法
        for (char i = '1'; i <= '9'; i++) {
            boolean thisChange = checkNumX(board, unsolve, i);
            if (thisChange) change = true;
        }
        if (change) {
            return solve(board, unsolve);
        } else {
            if (unsolve.size() > 0) {
                return UNDONE;
            } else {
                boolean valid = isValidSudoku(board);
                if (valid) {
                    return SUCCESS;
                } else {
                    return FAIL;
                }
            }
        }
    }

    private List<Character> checkX(char[][] board, Map<Integer, List<Character>> unsolve, int n) {
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
        return removed;
    }

    private List<Character> checkY(char[][] board, Map<Integer, List<Character>> unsolve, int n) {
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
        return removed;
    }

    private List<Character> checkCube(char[][] board, Map<Integer, List<Character>> unsolve, int n) {
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
        return removed;
    }

    private boolean checkNumX(char[][] board, Map<Integer, List<Character>> unsolve, char c) {
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
            if (!found) {
                if (poss.size() == 1) {
                    int integer = poss.get(0);
                    board[integer / 9][integer % 9] = c;
                    unsolve.remove(integer);
                    change = true;
                }
            }
        }
        return change;
    }


    private int recursion(char[][] rawBoard, Map<Integer, List<Character>> unsolve) {
        int status = solve(rawBoard, unsolve);
        if (status == UNDONE) {
            List<char[][]> boards = findPossBoard(rawBoard, unsolve);
            for (char[][] board : boards) {
                int newStatus = recursion(board, initUnsolveMap(board));
                if (newStatus == SUCCESS) {
                    for (int i = 0; i < 9; i++) {
                        System.arraycopy(board[i], 0, rawBoard[i], 0, 9);
                    }
                    return SUCCESS;
                }
            }
            return FAIL;
        } else {
            return status;
        }
    }

    private List<char[][]> findPossBoard(char[][] board, Map<Integer, List<Character>> unsolve) {
        List<char[][]> res = new ArrayList<>();
        int smallSize = Integer.MAX_VALUE;
        int smallIndex = 0;
        for (Integer integer : unsolve.keySet()) {
            List<Character> integers = unsolve.get(integer);
            if (integers.size() < smallSize) {
                smallSize = integers.size();
                smallIndex = integer;
            }
        }

        List<Character> cases = unsolve.get(smallIndex);
        for (Character aCase : cases) {
            char[][] newBoard = new char[9][9];
            for (int i = 0; i < 9; i++) {
                System.arraycopy(board[i], 0, newBoard[i], 0, 9);
            }
            newBoard[smallIndex / 9][smallIndex % 9] = aCase;
            res.add(newBoard);
        }
        return res;
    }


    private boolean isValidSudoku(char[][] board) {
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
                    return false;
                }
                //validate x
                if (xList.get(y).get(val) == null) {
                    xList.get(y).put(val, 1);
                } else {
                    return false;
                }
                //validate cube
                int cubeIndex = y / 3 * 3 + x / 3;
                if (cList.get(cubeIndex).get(val) == null) {
                    cList.get(cubeIndex).put(val, 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private Map<Integer, List<Character>> initUnsolveMap(char[][] board) {
        Map<Integer, List<Character>> unsolve = new TreeMap<>();
        final List<Character> initChars = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (int y = 0; y < board.length; y++) {
            char[] chars = board[y];
            for (int x = 0; x < chars.length; x++) {
                char aChar = chars[x];
                if (aChar == '.') {
                    unsolve.put(y * 9 + x, new ArrayList<>(initChars));
                }
            }
        }
        return unsolve;
    }
}
