package com.lnho.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public static void main(String[] args) {
        System.out.println(new Solution119().getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> line = new ArrayList<>();
        line.add(1);
        if (rowIndex == 0) {
            return line;
        }
        for (int i = 1; i <= rowIndex; i++) {
            int lastNum = 1;
            int currentNum = 1;
            for (int j = 1; j < i; j++) {
                currentNum = line.get(j);
                line.set(j, lastNum + currentNum);
                lastNum = currentNum;
            }
            line.add(1);
        }
        return line;
    }
}
