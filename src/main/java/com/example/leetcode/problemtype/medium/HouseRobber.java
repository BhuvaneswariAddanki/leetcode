package com.example.leetcode.problemtype.medium;

import java.util.Arrays;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * Leetcode link : https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        int amount = houseRobber.rob(nums);
        System.out.println(amount);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int lastToLast = 0;
        int lastHouse = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int current = Math.max(lastHouse, lastToLast + nums[i - 1]);
            lastToLast = lastHouse;
            lastHouse = current;
        }
        return lastHouse;
    }


    public int robUsingIterationAndDp(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {

        int lastToLastSum = 0;
        int lastSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = lastSum;
            lastSum = Math.max(lastSum, lastToLastSum + nums[i]);
            lastToLastSum = temp;
        }
        return lastSum;
    }

    int[] memo;

    public int robUsingDp(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob2(nums, nums.length - 1);
    }

    private int rob2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(rob2(nums, i - 2) + nums[i], rob2(nums, i - 1));
        memo[i] = result;
        return result;
    }


}
