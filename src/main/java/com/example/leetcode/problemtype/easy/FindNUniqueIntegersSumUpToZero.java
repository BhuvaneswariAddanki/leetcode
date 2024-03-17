package com.example.leetcode.problemtype.easy;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: [-1,0,1]
 * <p>
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: [0]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 * Leetcode link : https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
 */
public class FindNUniqueIntegersSumUpToZero {

    public int[] sumZeroWithSingleNegativeNum(int n) {

        int[] result = new int[n];
        if (n == 1) {
            result[0] = 0;
            return result;
        }
        int sum = (n - 1) * n / 2;
        for (int i = 1; i < n; i++) {
            result[i - 1] = i;
        }
        result[n - 1] = -sum;
        return result;


    }

    public int[] sumZero(int n) {
        int[] array = new int[n];
        int i = 0;
        if (n % 2 == 1) {
            array[i] = 0;
            i++;
        }
        for (; i < n; i += 2) {
            array[i] = i + 1;
            array[i + 1] = -1 * (i + 1);
        }
        return array;
    }
}
