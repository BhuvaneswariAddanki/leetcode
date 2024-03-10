package com.example.leetcode.problemtype.easy;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 * Leetcode link : https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }

    }
}
