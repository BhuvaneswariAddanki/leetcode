package com.example.leetcode.problemtype.medium;

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
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * <p>
 * <p>
 * <p>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * <p>
 * Leetcode link : https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int cur = 0;
        while (cur <= j) {
            if (nums[cur] == 0) {
                int temp = nums[i];
                nums[i] = nums[cur];
                nums[cur] = temp;
                i++;
                cur++;
            } else if (nums[cur] == 2) {
                int temp = nums[j];
                nums[j] = nums[cur];
                nums[cur] = temp;
                j--;
                cur++;
            } else {
                cur++;
            }
        }
    }

    public void sortColorsUsingOneMorePass(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
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
