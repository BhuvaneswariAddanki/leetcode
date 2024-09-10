package com.example.leetcode.problemtype.medium;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i : nums) sum+=i;

        if(sum%2!=0) return false;

        sum /= 2;

        boolean[] dp = new boolean[sum+1];

        dp[0] = true;

        for (int j : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= j) {
                    dp[i] = dp[i] || dp[i-j];
                }
            }
        }
        return dp[sum];
    }

    Boolean mem[][];

    public boolean canPartitionMemorization(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i : nums) sum += i;

        if (sum % 2 != 0) return false;

        sum /= 2;

        mem = new Boolean[n + 1][sum + 1];

        return subsetSum(nums, 0, sum);
    }

    boolean subsetSum(int[] nums, int pos, int sum) {
        if (sum == 0) return true;

        else if (pos >= nums.length || sum < 0) return false;

        if (mem[pos][sum] != null) return mem[pos][sum];

        mem[pos][sum] = subsetSum(nums, pos + 1, sum - nums[pos]) ||
                subsetSum(nums, pos + 1, sum);
        return mem[pos][sum];
    }


    public boolean canPartitionUsingIterationDp(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i : nums) sum += i;

        if (sum % 2 != 0) return false;

        sum /= 2;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = false;
                else if (nums[i - 1] > j)     // if curr sum value is greater than the current element value then just skip(take previous value)
                    dp[i][j] = dp[i - 1][j];
                else if (nums[i - 1] == j)  // we got required sum
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[n][sum];
    }



}
