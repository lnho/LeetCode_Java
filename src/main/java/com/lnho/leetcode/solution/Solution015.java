package com.lnho.leetcode.solution;

import com.lnho.leetcode.common.TestUtil;

import java.util.*;

/**
 * Created by Administrator on 2016-05-04.
 */
public class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //nums先进行排序
        Arrays.sort(nums);
        TestUtil.print(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k <= nums.length - 1; k++) {
                    if (nums[i] + nums[j] * 2 > 0) {
                        break;
                    }
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //nums先进行排序
        Arrays.sort(nums);
        TestUtil.print(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.get(num) == null) {
                List<Integer> subscripts = new ArrayList<>();
                subscripts.add(i);
                map.put(num, subscripts);
            } else {
                map.get(num).add(i);
            }
        }
        for (int i = 0; i <= nums.length - 3; i++) {
            int numi = nums[i];
            if (numi > 0) {
                break;
            }
            if (i > 0 && numi == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= nums.length - 2; j++) {
                int finalNum = -numi - nums[j];
                if (finalNum < nums[j]) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                List<Integer> subscripts = map.get(finalNum);
                if (subscripts == null) {
                    continue;
                }
                for (Integer subscript : subscripts) {
                    if (subscript != j && subscript != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(numi);
                        list.add(nums[j]);
                        list.add(nums[subscript]);
                        res.add(list);
                        break;
                    }
                }
            }
        }
        return res;
    }
}
