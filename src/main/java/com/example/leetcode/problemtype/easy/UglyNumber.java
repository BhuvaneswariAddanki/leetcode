package com.example.leetcode.problemtype.easy;

/**
 * 263. Ugly Number
 * Easy
 * Topics
 * Companies
 * <p>
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * <p>
 * Given an integer n, return true if n is an ugly number.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * <p>
 * Example 3:
 * <p>
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= n <= 231 - 1
 */
public class UglyNumber {
    public static boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}
