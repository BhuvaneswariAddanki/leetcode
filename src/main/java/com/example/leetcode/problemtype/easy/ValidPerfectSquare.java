package com.example.leetcode.problemtype.easy;

/**
 * 367. Valid Perfect Square
 * Easy
 * Topics
 * Companies
 * <p>
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 * <p>
 * A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
 * <p>
 * You must not use any built-in library function, such as sqrt.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 * <p>
 * Example 2:
 * <p>
 * Input: num = 14
 * Output: false
 * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 231 - 1
 * <p>
 * Leetcode link : https://leetcode.com/problems/valid-perfect-square/description/
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {

        if (num == 1)
            return true;
        long low = 1, high = num / 2, mid = 0;
        long nums = (long) num;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if ((mid * mid) == nums)
                return true;
            else if ((mid * mid) < nums)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
