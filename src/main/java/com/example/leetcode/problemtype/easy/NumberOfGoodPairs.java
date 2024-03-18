package com.example.leetcode.problemtype.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums, return the number of good pairs.
 * <p>
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * Leetcode link : https://leetcode.com/problems/number-of-good-pairs/description/
 */
public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int numberCount = numberCountMap.getOrDefault(num, 0);
            ans += numberCount;
            numberCountMap.put(num, numberCount + 1);
        }
        return ans;
    }
}
