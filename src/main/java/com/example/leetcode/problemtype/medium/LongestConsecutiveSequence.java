package com.example.leetcode.problemtype.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int curMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                curMax = 1;
            } else {
                curMax++;
            }
            max = Math.max(curMax, max);
        }
        return max;

    }

    public int longestConsecutive2(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int max = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int length = 0;
                while (set.contains(n + length)) {
                    length++;
                }
                max = Math.max(max, length);

            }
        }
        return max;

    }

}
