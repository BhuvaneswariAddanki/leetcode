package com.example.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * https://leetcode.com/problems/3sum/
 */
public class ThreeNumbersSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] <= 0) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    int target = -nums[i];
                    int low = i + 1, high = n - 1;
                    while (low < high) {
                        if (nums[low] + nums[high] == target) {
                            response.add(List.of(nums[i], nums[low], nums[high]));
                            while (low < high && nums[low] == nums[low + 1]) {
                                low++;
                            }
                            while (low < high && nums[high] == nums[high - 1]) {
                                high--;
                            }
                            low++;
                            high--;
                        } else if (nums[low] + nums[high] < target) {
                            low++;
                        } else {
                            high--;
                        }
                    }
                }
            }
        }
        return response;
    }
}
