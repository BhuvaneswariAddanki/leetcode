package com.example.leetcode.problemtype.medium;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 * <p>
 * Leetcode link : https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {

    public boolean canJumpFromLastPosCheck(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;

    }

    public boolean canJumpUsingIteration(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int lastIndexTobeReached = 0;
        int currentIndex = 0;
        while (currentIndex < nums.length && currentIndex <= lastIndexTobeReached) {
            if (nums[currentIndex] + currentIndex >= nums.length - 1) {
                return true;
            }
            lastIndexTobeReached = Math.max(nums[currentIndex] + currentIndex, lastIndexTobeReached);
            currentIndex++;

        }
        return false;
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int[] cache = new int[nums.length];
        return canReachEnd(nums, 0, cache);

    }

    private boolean canReachEnd(int[] nums, int i, int[] cache) {
        if (cache[i] == -1) {
            return false;
        }
        if (nums[i] + i >= nums.length - 1) {
            return true;
        }
        for (int j = 1; j <= nums[i]; j++) {
            boolean reached = canReachEnd(nums, i + j, cache);

            if (reached) {
                return true;
            } else {
                cache[i + j] = -1;
            }
        }
        return false;
    }


}
