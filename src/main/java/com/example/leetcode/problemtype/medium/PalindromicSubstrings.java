package com.example.leetcode.problemtype.medium;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * <p>
 * A string is a palindrome when it reads the same backward as forward.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * <p>
 * Leetcode link : https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddCount = palindromeCenterBased(s, i, i);
            int evenCount = palindromeCenterBased(s, i, i + 1);
            total += oddCount + evenCount;

        }
        return total;

    }

    private int palindromeCenterBased(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;

        }
        return count;
    }
}
