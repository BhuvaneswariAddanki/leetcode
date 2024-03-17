package com.example.leetcode.problemtype.easy;

import java.util.Arrays;

/**
 * You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 * <p>
 * Return the array after sorting it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [0,1,2,3,4,5,6,7,8]
 * Output: [0,1,2,4,8,3,5,6,7]
 * Explantion: [0] is the only integer with 0 bits.
 * [1,2,4,8] all have 1 bit.
 * [3,5,6] have 2 bits.
 * [7] has 3 bits.
 * The sorted array by bits is [0,1,2,4,8,3,5,6,7]
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * Output: [1,2,4,8,16,32,64,128,256,512,1024]
 * Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 104
 * Leetcode link: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
 */
public class SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        int[] test = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        SortIntegersByTheNumberOf1Bits sortIntegersByTheNumberOf1Bits = new SortIntegersByTheNumberOf1Bits();
        sortIntegersByTheNumberOf1Bits.sortByBits(test);
        for (int num : test) {
            System.out.print(num + "\t");
        }
    }

    public int[] sortByBits(int[] arr) {

        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 2];
        int k = 0;
        while (i <= mid && j <= high) {
            if (countOfOnes(nums[i]) < countOfOnes(nums[j])) {
                temp[k++] = nums[i++];
            } else if (countOfOnes(nums[i]) == countOfOnes(nums[j])) {
                if (nums[i] < nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    temp[k++] = nums[j++];
                }
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int r = 0, p = low; p <= high; p++, r++) {
            nums[p] = temp[r];
        }

    }

    private int countOfOnes(int num) {
        int sum = 0;
        while (num != 0) {
            sum++;
            num &= (num - 1);
        }
        return sum;
    }

    public int[] sortByBitsUsingInbuiltSorting(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted((a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b))
                .mapToInt(i -> i).toArray();

    }
}
