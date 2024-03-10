package com.example.leetcode.problemtype.easy;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 * <p>
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int requiredSum = (nums.length + 1) * nums.length / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return requiredSum - sum;
    }
}
