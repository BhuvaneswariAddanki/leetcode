package com.example.leetcode.problemtype.medium;

/**
 * The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus the sum of the elements at odd indices.
 * <p>
 * For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
 * <p>
 * Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing the elements of the subsequence).
 * <p>
 * A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,5,3]
 * Output: 7
 * Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [5,6,7,8]
 * Output: 8
 * Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [6,2,1,2,4,5]
 * Output: 10
 * Explanation: It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class MaximumAlternatingSubsequenceSum {

    public long maxAlternatingSum(int[] nums) {
        long res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res += Math.max(nums[i] - nums[i - 1], 0);
        }
        return res;
    }

    public long maxAlternatingSumUsingDp(int[] nums) {
        int n = nums.length;
        Long[][] dp = new Long[nums.length][2];
        return solve(nums, 0, n, 1, dp);
    }

    public long solve(int[] nums, int index, int n, int sign, Long[][] dp) {

        if (index >= n) return 0;
        int pos = sign > 0 ? 0 : 1;
        if (dp[index][pos] != null) {
            return dp[index][pos];
        }
        // Skip current element
        long skip = solve(nums, index + 1, n, sign, dp);
        // Take current element
        long take = (nums[index] * sign) + solve(nums, index + 1, n, -sign, dp);
        dp[index][pos] = Math.max(skip, take);
        return dp[index][pos];
    }

}

