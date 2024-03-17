package com.example.leetcode.problemtype.easy;

/**
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 * <p>
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 * <p>
 * Return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,3]
 * Output: [2,3]
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 2 * 104
 * nums.length is even.
 * Half of the integers in nums are even.
 * 0 <= nums[i] <= 1000
 * <p>
 * Follow Up: Could you solve it in-place?
 * Leetcode link : https://leetcode.com/problems/sort-array-by-parity-ii/description/
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {

        int evenIndex = 0;
        int oddIndex = nums.length - 1;
        while (evenIndex < nums.length - 1 && oddIndex > 0) {
            while (evenIndex < nums.length - 1 && nums[evenIndex] % 2 == 0) {
                evenIndex = evenIndex + 2;
            }
            while (oddIndex > 0 && nums[oddIndex] % 2 != 0) {
                oddIndex = oddIndex - 2;
            }

            if (evenIndex < nums.length - 1 && oddIndex > 0) {
                swap(nums, evenIndex, oddIndex);
                evenIndex = evenIndex + 2;
                oddIndex = oddIndex - 2;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArrayByParityIIUsingExtraSpace(int[] nums) {
        int[] a = new int[nums.length];
        int o = 1;
        int e = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                a[e] = num;
                e += 2;
            } else {
                a[o] = num;
                o += 2;
            }

        }
        return a;

    }
}
