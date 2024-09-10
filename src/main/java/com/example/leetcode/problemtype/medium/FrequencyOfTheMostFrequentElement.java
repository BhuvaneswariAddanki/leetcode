package com.example.leetcode.problemtype.medium;

import java.util.Arrays;

/**
 * The frequency of an element is the number of times it occurs in an array.
 * <p>
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 * <p>
 * Return the maximum possible frequency of an element after performing at most k operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 * <p>
 * Leetcode link : https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
 */
public class FrequencyOfTheMostFrequentElement {

    /**
     * @param nums
     * @param k
     * @return
     */

    public int maxFrequency(int[] nums, int k) {
        //Step-1: Sorting->
        Arrays.sort(nums);
        //Step-2: Two-Pointers->
        int left = 0;
        int right = 0;
        long res = 0;
        long total = 0;
        //Iterating over the array:
        while (right < nums.length) {
            total += nums[right];

            //The value of "totalSum+k" should be ">=" "windowSize*nums[right]"
            //then only the window is possible else decrease the "totalSum"
            //till the value "total+k" is ">=" "windowSize*nums[right]"

            while (nums[right] * (right - left + 1L) > total + k) {
                total -= nums[left];
                left += 1;
            }

            res = Math.max(res, right - left + 1L);
            right += 1;
        }

        return (int) res;
    }
}