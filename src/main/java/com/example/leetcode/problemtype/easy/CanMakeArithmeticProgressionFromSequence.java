package com.example.leetcode.problemtype.easy;

import java.util.Arrays;

/**
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 * <p>
 * Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [3,5,1]
 * Output: true
 * Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [1,2,4]
 * Output: false
 * Explanation: There is no way to reorder the elements to obtain an arithmetic progression.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 1000
 * -106 <= arr[i] <= 106
 * <p>
 * Leetcode link : https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/
 */
public class CanMakeArithmeticProgressionFromSequence {


    public boolean canMakeArithmeticProgressionUsingInbuiltSort(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (diff != (arr[i + 1] - arr[i]))
                return false;
        }
        return true;

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

        int difference = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int start = low, end = high, mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }

        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
