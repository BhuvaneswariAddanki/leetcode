package com.example.leetcode;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        String response = obj.longestPalindrome("ababd");
        System.out.println(response);
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {

            int oddMax = findPossibleMaxPalindrome(s, i, i);
            int evenMax = findPossibleMaxPalindrome(s, i, i + 1);
            int currentMax = Math.max(oddMax, evenMax);
            if (currentMax > end - start) {
                start = i - (currentMax - 1) / 2;
                end = i + currentMax / 2;
            }
        }
        return s.substring(start, end + 1);

    }
    private int findPossibleMaxPalindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
