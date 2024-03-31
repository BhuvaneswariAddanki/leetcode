package com.example.leetcode.problemtype.medium;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * Leetcode link : https://leetcode.com/problems/house-robber-ii/description/
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int includeFirstHouse = rob(nums, 0, nums.length - 2);
        int excludeFirstHouse = rob(nums, 1, nums.length - 1);

        return Math.max(includeFirstHouse, excludeFirstHouse);
    }


    public int rob(int[] nums, int start, int end) {

        int lastSum = nums[start];
        int lastToLastSum = 0;
        for (int i = start + 1; i <= end; i++) {
            int temp = lastSum;
            lastSum = Math.max(lastSum, lastToLastSum + nums[i]);
            lastToLastSum = temp;
        }
        return lastSum;
    }


}
