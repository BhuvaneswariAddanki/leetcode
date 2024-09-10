package com.example.leetcode.problemtype.medium;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * <p>
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 * <p>
 * Leetcode link : https://leetcode.com/problems/jump-game-ii/description/
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int i = 0;
        int count = 0;
        if (nums.length == 1) {
            return 0;
        }
        while (i < nums.length) {
            count++;
            int range = nums[i] + i;
            if (range >= nums.length - 1) {
                break;
            }

            int max = 0;
            int temp = 0;
            for (int k = i + 1; k <= range; k++) {
                if (max <= nums[k] + k) {
                    max = nums[k] + k;
                    temp = k;
                }
            }
            i = temp;

        }
        return count;
    }
}
