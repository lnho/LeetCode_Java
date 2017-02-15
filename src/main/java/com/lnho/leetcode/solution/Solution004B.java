package com.lnho.leetcode.solution;

public class Solution004B {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
        } else {
            return findMedianSortedArrays(nums2, 0, nums2.length - 1, nums1, 0, nums1.length - 1);
        }
    }

    public double findMedianSortedArrays(int[] m, Integer mMin, Integer mMax, int[] n, Integer nMin, Integer nMax) {
        int mLen = mMax - mMin + 1;
        double mMid = 0;
        int mIndexMin = mMin + mLen / 2, mIndexMax = mMin + mLen / 2;
        if (mLen == 0) {
            return 0.0;
        }
        if (mLen % 2 == 0) {
            mIndexMin--;
            try {
                mMid = (m[mIndexMin] + m[mIndexMax]) / 2.0;
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        } else {
            mMid = m[mIndexMin] / 1.0;
        }
        int nLen = nMax - nMin + 1;
        if (nLen == 0) {
            return 0.0;
        }
        double nMid = 0;
        int nIndexMin = nMin + nLen / 2, nIndexMax = nMin + nLen / 2;
        if (nLen % 2 == 0) {
            nIndexMin--;
            try {
                nMid = (n[nIndexMin] + n[nIndexMax]) / 2.0;
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        } else {
            nMid = n[nIndexMin] / 1.0;
        }
        if (mMid == nMid) {
            return mMid;
        } else if (mMid < nMid) {
            return findMedianSortedArrays(m, mIndexMin, mMax, n, nMin, nMax - (mIndexMin - nMin));
        } else {
            return findMedianSortedArrays(m, mMin, mIndexMax, n, nMin + (mMax - mIndexMax), nMax);
        }
    }
}
