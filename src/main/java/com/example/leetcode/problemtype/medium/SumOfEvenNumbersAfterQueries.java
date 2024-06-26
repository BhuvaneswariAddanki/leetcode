package com.example.leetcode.problemtype.medium;

/**
 * You are given an integer array nums and an array queries where queries[i] = [vali, indexi].
 * <p>
 * For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.
 * <p>
 * Return an integer array answer where answer[i] is the answer to the ith query.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation: At the beginning, the array is [1,2,3,4].
 * After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1], queries = [[4,0]]
 * Output: [0]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * 1 <= queries.length <= 104
 * -104 <= vali <= 104
 * 0 <= indexi < nums.length
 * <p>
 * Leetcode link : https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/
 */
public class SumOfEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        int[] result = new int[queries.length];
        int k = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        for (int[] query : queries) {
            int val = query[0];
            int index = query[1];
            if (nums[index] % 2 == 0) {
                sum -= nums[index];
            }
            nums[index] += val;
            if (nums[index] % 2 == 0) {
                sum += nums[index];
            }
            result[k++] = sum;

        }
        return result;
    }
}
