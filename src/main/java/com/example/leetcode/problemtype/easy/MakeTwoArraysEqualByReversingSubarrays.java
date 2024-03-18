package com.example.leetcode.problemtype.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.
 * <p>
 * Return true if you can make arr equal to target or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = [1,2,3,4], arr = [2,4,1,3]
 * Output: true
 * Explanation: You can follow the next steps to convert arr to target:
 * 1- Reverse subarray [2,4,1], arr becomes [1,4,2,3]
 * 2- Reverse subarray [4,2], arr becomes [1,2,4,3]
 * 3- Reverse subarray [4,3], arr becomes [1,2,3,4]
 * There are multiple ways to convert arr to target, this is not the only way to do so.
 * <p>
 * Example 2:
 * <p>
 * Input: target = [7], arr = [7]
 * Output: true
 * Explanation: arr is equal to target without any reverses.
 * <p>
 * Example 3:
 * <p>
 * Input: target = [3,7,9], arr = [3,7,11]
 * Output: false
 * Explanation: arr does not have value 9 and it can never be converted to target.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * target.length == arr.length
 * 1 <= target.length <= 1000
 * 1 <= target[i] <= 1000
 * 1 <= arr[i] <= 1000
 * Leetcode link : https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/
 */
public class MakeTwoArraysEqualByReversingSubarrays {

    public boolean canBeEqual(int[] target, int[] arr) {

        if (target == null || arr == null) {
            return target == arr;
        } else if (target.length != arr.length) {
            return false;
        } else {

            Map<Integer, Integer> numbersMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                numbersMap.put(target[i], numbersMap.getOrDefault(target[i], 0) + 1);
                numbersMap.put(arr[i], numbersMap.getOrDefault(arr[i], 0) - 1);
                if (numbersMap.get(target[i]) == 0) {
                    numbersMap.remove(target[i]);
                }
                if (Integer.valueOf(0).equals(numbersMap.get(arr[i]))) {
                    numbersMap.remove(arr[i]);
                }
            }
            return numbersMap.isEmpty();

        }
    }
}
