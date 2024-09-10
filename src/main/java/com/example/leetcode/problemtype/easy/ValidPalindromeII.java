package com.example.leetcode.problemtype.easy;

/**
 * 680. Valid Palindrome II
 * Easy
 * Topics
 * Companies
 * <p>
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;

    }

    private boolean isPalindrome(String s, int i, int j) {
        int start = i;
        int end = j;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
