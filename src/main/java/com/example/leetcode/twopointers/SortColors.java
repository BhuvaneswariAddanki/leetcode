package com.example.leetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int i = 0;
        for (; i < map.getOrDefault(0, 0); i++) {
            nums[i] = 0;
        }
        int count = i + map.getOrDefault(1, 0);
        for (; i < count; i++) {
            nums[i] = 1;
        }
        count = i + map.getOrDefault(2, 0);
        for (; i < count; i++) {
            nums[i] = 2;
        }

    }
}
