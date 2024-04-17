package com.example.leetcode.problemtype.medium;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You cannot get a non-decreasing array by modifying at most one element.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -105 <= nums[i] <= 105
 * <p>
 * Leetcode link : https://leetcode.com/problems/non-decreasing-array/description/
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] test1 = new int[]{3,4,2,3};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
       boolean result = nonDecreasingArray.checkPossibility(test1);
       System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {
        int modified=0;
        int prev = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < prev) {
                if (modified++ == 1) return false;
                if (i>=2 && nums[i-2] > nums[i]) continue;
            }
            prev = nums[i];
        }
        return true;
    }
    public boolean checkPossibilityChangingTheArray(int[] nums) {
        for (int i=1, modified=0; i<nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                if (modified++ == 1) return false;
                if (i<2 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        return true;
    }
}
