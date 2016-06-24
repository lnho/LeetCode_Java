package com.lnho.leetcode.solution;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution091Test {
    private Solution091A solutionA = new Solution091A();
    private Solution091B solutionB = new Solution091B();
    private static List<String> input = new ArrayList<>();

    @BeforeClass
    public static void init() {
        input.add("33");
        input.add("1111");
        input.add("1191111118");
        input.add("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253");
    }

    @Test
    public void solutionA() throws Exception {
        Long startTime = System.currentTimeMillis();
        for (String s : input) {
            int actual = solutionA.numDecodings(s);
            System.out.println(actual);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("solutionA,costs=" + (endTime - startTime));
    }

    @Test
    public void solutionB() throws Exception {
        Long startTime = System.currentTimeMillis();
        for (String s : input) {
            int actual = solutionB.numDecodings(s);
            System.out.println(actual);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("solutionB,costs=" + (endTime - startTime));
    }
}