package com.lnho.leetcode.solution;

import java.util.Objects;

public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        } else if (nums1.length == 0) {
            return getMid(nums2);
        } else if (nums2.length == 0) {
            return getMid(nums1);
        }
        Double mid1 = getMid(nums1), mid2 = getMid(nums2);
        int len = nums1.length + nums2.length;
        int index1 = len / 2, index2 = len / 2;
        if (len % 2 == 0) index1--;
        int sum = 0, current, j = 0, k = 0;
        if (Objects.equals(mid1, mid2)) {
            return mid1;
        } else if (mid1 < mid2) {
            j = nums1.length < 2 ? 0 : nums1.length / 2 - 1;
        } else {
            k = nums2.length < 2 ? 0 : nums2.length / 2 - 1;
        }
        for (int i = j + k; i < len; i++) {
            if (j >= nums1.length) {
                if (sum == 0) {
                    sum = nums2[index1 - nums1.length];
                }
                return (sum + nums2[index2 - nums1.length]) / 2.0;
            } else if (k >= nums2.length) {
                if (sum == 0) {
                    sum = nums1[index1 - nums2.length];
                }
                return (sum + nums1[index2 - nums2.length]) / 2.0;
            }
            if (nums1[j] < nums2[k]) {
                current = nums1[j];
                j++;
            } else {
                current = nums2[k];
                k++;
            }
            if (i == index1) {
                if (index1 == index2) {
                    return current;
                }
                sum = current;
            }
            if (i == index2) {
                sum += current;
                return sum / 2.0;
            }
        }
        return 0;
    }

    public Double getMid(int n[]) {
        int len = n.length;
        if (len == 0) {
            return null;
        }
        if (len % 2 == 0) {
            return (n[len / 2 - 1] + n[len / 2]) / 2.0;
        } else {
            return n[len / 2] / 1.0;
        }
    }
}
