package com.lnho.leetcode.solution;

public class Solution482 {
    public String licenseKeyFormatting(String S, int K) {
        int len = 0;
        int up = 'a' - 'A';
        char[] charArr = S.toCharArray();
        for (int i = 0; i <= charArr.length - 1; i++) {
            char ch = charArr[i];
            if (ch == '-') {
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                charArr[i] -= up;
            }
            charArr[len] = charArr[i];
            len++;
        }
        if(len==0) return "";
        int newLen = len % K == 0 ? len + len / K - 1 : len + len / K;
        char[] newArr = new char[newLen];
        int j = len;
        for (int i = newLen - 1; i >= 0; i--) {
            if (i != newLen - 1 && (newLen-i) % (K+1) == 0) {
                newArr[i] = '-';
            } else {
                newArr[i] = charArr[--j];
            }
        }
        return String.valueOf(newArr);
    }

    public static void main(String[] args) {
        Solution482 s = new Solution482();
        String result = s.licenseKeyFormatting("2-4A0r7-4k", 4);
        System.out.println(result);
    }
}
