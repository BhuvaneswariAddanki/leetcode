package com.example.leetcode.problemtype.easy;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * <p>
 * Return the running sum of nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 * leetcode link : https://leetcode.com/problems/running-sum-of-1d-array/description/
 */
public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int cumulativeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            result[i] = cumulativeSum;
        }
        return result;
    }

    public int[] runningSumInplace(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
