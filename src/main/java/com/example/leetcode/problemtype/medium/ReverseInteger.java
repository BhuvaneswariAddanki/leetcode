package com.example.leetcode.problemtype.medium;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * Leetcode link : https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger {

    public int reverse2(int x) {

        long finalNum = 0;
        int y = x < 0 ? -1 : 1;
        x = x * y;
        while (x != 0) {
            int lastDig = x % 10;
            finalNum += lastDig;
            finalNum = finalNum * 10;
            x = x / 10;
        }
        finalNum = finalNum / 10;
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (finalNum * y);
    }

    public int reverse(int x) {
        long result = 0;
        int r;
        while (x != 0) {
            r = x % 10;
            result = (result * 10) + r;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) result;
    }
}
