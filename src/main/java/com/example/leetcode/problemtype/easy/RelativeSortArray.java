package com.example.leetcode.problemtype.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * Example 2:
 * <p>
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * All the elements of arr2 are distinct.
 * Each arr2[i] is in arr1.
 * <p>
 * Leetcode link : https://leetcode.com/problems/relative-sort-array/description/
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> sortedNumsMap = new TreeMap<>();
        for (int ele : arr1) {
            sortedNumsMap.put(ele, sortedNumsMap.getOrDefault(ele, 0) + 1);
        }
        int[] result = new int[arr1.length];
        int index = 0;
        for (int ele : arr2) {
            int count = sortedNumsMap.getOrDefault(ele, 0);
            for (int i = 0; i < count; i++) {
                result[index++] = ele;
            }
            sortedNumsMap.remove(ele);
        }
        for (Map.Entry<Integer, Integer> entry : sortedNumsMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
}
