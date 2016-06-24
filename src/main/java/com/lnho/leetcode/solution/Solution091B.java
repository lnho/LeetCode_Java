package com.lnho.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution091B
 *
 * @author lnho
 * @date 2016-06-24
 */
public class Solution091B {
    private static Map<Integer, Integer> fMap = new HashMap<>();

    public int numDecodings(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        char[] chars = input.toCharArray();
        if (!clean(chars)) return 0;
        return cal(chars);
    }

    /**
     * 将字符串中的数字进行校验、转换整理
     * 将数字分为4类
     * （1）拆也可以不拆也可以，但不能打头，例如18的8、26的6，用Y替换
     * （2）必须拆，并且不能打头，例如28的8，直接用X替换
     * （3）拆也可以不拆也可以，但可以打头，例如11的1，不修改
     * （4）必须与前一个数字合并，例如10的0，将前一个数字和本数字替换为XX
     * 上述X表示隔断，即X前后的数字分开计算，再乘起来
     * 上述Y表示隔断，与X类似，但是Y参与前面的数字计算。
     *
     * @param chars
     * @return 校验结果是否合法
     * @author lnho
     * @date 2016-06-24
     */
    private boolean clean(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (current == '0' || (current >= '3' && current <= '9')) {
                if (i == 0) {
                    if (current == '0') {
                        return false;
                    } else {
                        //为第一位数字，符合情况（2）
                        chars[i] = 'X';
                        continue;
                    }
                }
                char previous = chars[i - 1];
                if (previous != '1' && previous != '2') {
                    if (current == '0') {
                        return false;
                    } else {
                        //前面为隔断（X,Y），符合情况（2）
                        chars[i] = 'X';
                        continue;
                    }
                }

                if (previous == '2' && current > '6') {
                    //符合情况（2）
                    chars[i] = 'X';
                    continue;
                }
                if (current == '0') {
                    //符合情况（4）
                    chars[i - 1] = 'X';
                    chars[i] = 'X';
                } else {
                    //符合情况（1）
                    chars[i] = 'Y';
                }
            }
            //符合情况（3）
        }
        return true;
    }

    /**
     * 计算结果
     *
     * @param chars 经过上一个步骤，入参的字符数组中只包括1，2，X，Y了
     * @return
     * @author lnho
     * @date 2016-06-24
     */
    private int cal(char[] chars) {
        int count = 0;
        int sum = 1;
        for (char current : chars) {
            if (current == '1' || current == '2') {
                count++;
            } else if (current == 'Y') {
                sum *= fibonacci(count + 1);
                count = 0;
            } else {
                //'X'
                if (count != 0) {
                    sum *= fibonacci(count);
                    count = 0;
                }
            }
        }
        if (count != 0) {
            sum *= fibonacci(count);
        }
        return sum;
    }


    /**
     * 获取斐波那契数值
     *
     * @param n
     * @return
     * @author lnho
     * @date 2016-06-24
     */
    private int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        Integer fn = fMap.get(n);
        if (fn == null) {
            fn = fibonacci(n - 1) + fibonacci(n - 2);
            fMap.put(n, fn);
        }
        return fn;
    }
}
