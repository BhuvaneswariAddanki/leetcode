package com.example.leetcode.problemtype.easy;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * <p>
 * leetcode link : https://leetcode.com/problems/max-consecutive-ones/description/
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 0) {
                maxCount = Math.max(count, maxCount);
                count = 0;
            } else {
                count++;
            }

        }
        return Math.max(maxCount, count);

    }

}
