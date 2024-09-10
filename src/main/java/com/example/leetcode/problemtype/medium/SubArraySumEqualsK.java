package com.example.leetcode.problemtype.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * Attempted
 * Medium
 * Topics
 * Companies
 * Hint
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * <p>
 * Leetcode link : https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubArraySumEqualsK {

        public int subarraySum(int[] nums, int k) {
            int sum = 0;
            int result = 0;
            Map<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0, 1);

            for (int num : nums) {
                sum += num;
                if (preSum.containsKey(sum - k)) {
                    result += preSum.get(sum - k);
                }
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }

            return result;
        }
    public int subArraySumBruteForce(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i ; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
