package com.example.leetcode.problemtype.medium;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: a = 2, b = 3
 * Output: 5
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -1000 <= a, b <= 1000
 * <p>
 * Leetcode link : https://leetcode.com/problems/sum-of-two-integers/description/
 */
public class SumOfTwoIntegers {
    /**
     * https://leetcode.com/problems/sum-of-two-integers/solutions/84278/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently/
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);

    }
}
