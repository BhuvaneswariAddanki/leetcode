package com.example.leetcode.problemtype.medium;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * <p>
 * Leetcode link : https://leetcode.com/problems/4sum/description/
 */
public class Four4Sum {
    private List<List<Integer>> res;



    public List<List<Integer>> fourSum(int[] nums, int target) {
        return new AbstractList<>() {
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            public int size() {
                init();
                return res.size();
            }

            private void init() {
                if (res != null) return;
                Arrays.sort(nums);
                ArrayList<List<Integer>> ans = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    if (i > 0 && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    for (int j = i + 1; j < nums.length; j++) {
                        if (j > i + 1 && nums[j] == nums[j - 1]) {
                            continue;
                        }
                        twoSum(i, j, ans);
                    }
                }
                res = ans;
            }

            private void twoSum(int i, int j, ArrayList<List<Integer>> ans) {
                //System.out.println("target: " + target);
                long t = (long) target - nums[i] - nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (j + 1 < left && nums[left - 1] == nums[left]) {
                        left++;
                        continue;
                    }
                    long sum = nums[left] + nums[right];
                    //System.out.println(sum +  " " + t);
                    if (sum > t) {
                        right--;
                    } else if (sum < t) {
                        left++;
                    } else {
                        //System.out.println("left: " + left + " right: " + right);
                        ArrayList<Integer> al = new ArrayList<>(4);
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[left]);
                        al.add(nums[right]);
                        ans.add(al);
                        left++;
                    }
                }
            }
        };
    }

    public List<List<Integer>> fourSumUsing2Sum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);

    }

    private List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (start == nums.length) {
            return result;
        }
        long average = target / k;
        if (nums[start] > average || average > nums[nums.length - 1] ) {
            return result;
        }
        if (k == 2) return twoSum(nums, target, start);

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    result.add(new ArrayList<>(Collections.singletonList(nums[i])));
                    result.get(result.size() - 1).addAll(subset);
                }
            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, long target, int start) {
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }
}
