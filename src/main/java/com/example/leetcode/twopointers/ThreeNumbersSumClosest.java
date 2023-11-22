package com.example.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeNumbersSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        ThreeNumbersSumClosest object = new ThreeNumbersSumClosest();
        int result = object.threeSumClosest(nums, 1);
        System.out.print(result);

    }

    public int threeSumClosest(int[] nums, int t) {
        Arrays.sort(nums);
        int curr = 0;
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                curr = nums[i] + nums[j] + nums[k];
                if (curr == t) return t;
                if (curr < t)
                    j++;
                else
                    k--;
                if (Math.abs(t - curr) < Math.abs(t - ans)) {
                    ans = curr;
                }
            }
        }
        return ans;
    }
}
