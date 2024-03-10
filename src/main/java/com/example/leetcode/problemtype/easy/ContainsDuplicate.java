package com.example.leetcode.problemtype.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * Leetcode link : https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }
}
