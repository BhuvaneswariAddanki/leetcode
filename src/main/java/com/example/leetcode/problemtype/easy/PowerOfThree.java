package com.example.leetcode.problemtype.easy;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * <p>
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 33
 * <p>
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3x = 0.
 * <p>
 * Example 3:
 * <p>
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3x = (-1).
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 * <p>
 * https://leetcode.com/problems/power-of-three/description/
 */
public class PowerOfThree {
    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        boolean result = powerOfThree.isPowerOfThree(27);
    }

    public boolean isPowerOfThree(int n) {
        return Math.log10(n) / Math.log10(3) % 1 == 0;
    }

    public boolean isPowerOfThreeIteration(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
