package com.example.leetcode.problemtype.easy;

/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * Leetcode Link : https://leetcode.com/problems/palindrome-number/description/
 */
public class PalindromeNumber {

    /**
     * There is another approach to this problem:
     * <p>
     * We can store one half of the integer in a another variable in reversed order.
     * Then we compare it to the other unaltered half of the number
     * and see if they are equal or not [which should be in case of palindromes]
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverse = 0;

        while (x > reverse) {
            int r = x % 10;
            reverse = reverse * 10 + r;
            x = x / 10;
        }
        return (x == reverse || x == reverse / 10);

    }
}
