package com.example.leetcode.problemtype.easy;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * Leetcode link : https://leetcode.com/problems/majority-element/description/
 * https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int ele = -1;
        int majority = 0;
        for (int num : nums) {
            if (majority == 0) {
                ele = num;
            }
            if (ele == num) {
                majority++;
            } else {
                majority--;
            }
        }
        // If there is no guarantee of having one, then cross check on the occurrences
        int count = 0;
        for (int num : nums) {
            if (num == ele) {
                count++;
            }
        }
        return count > (nums.length / 2) ? ele : -1;
    }

}
