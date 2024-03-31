package com.example.leetcode.problemtype.medium;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * <p>
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 * <p>
 * Leetcode link : https://leetcode.com/problems/divide-two-integers/description/
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = 2;
        DivideTwoIntegers obj = new DivideTwoIntegers();
        int quotient = obj.divide(dividend, divisor);
        System.out.println(quotient);
    }

    public int divide(int dividend, int divisor) {

        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int result = 0, temp =0;
        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++) ;
            res += 1 << x;
            a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;

    }
}
