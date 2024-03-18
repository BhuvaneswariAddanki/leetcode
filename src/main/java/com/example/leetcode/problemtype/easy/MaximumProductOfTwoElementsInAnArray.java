package com.example.leetcode.problemtype.easy;

/**
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [3,7]
 * Output: 12
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 * Leetcode link : https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
 */
public class MaximumProductOfTwoElementsInAnArray {

    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (secondMax < num) {
                secondMax = num;
            }
        }
        return (max - 1) * (secondMax - 1);

    }
}
