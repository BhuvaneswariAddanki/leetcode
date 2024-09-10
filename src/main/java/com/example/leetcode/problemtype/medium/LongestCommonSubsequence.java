package com.example.leetcode.problemtype.medium;

import java.util.Arrays;

/**
 * 1143. Longest Common Subsequence
 * Medium
 * Topics
 * Companies
 * Hint
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * <p>
 * Example 2:
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * <p>
 * Example 3:
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 * <p>
 * Leetcode link : https://leetcode.com/problems/longest-common-subsequence/description/
 */
public class LongestCommonSubsequence {


    public int longestCommonSubsequence(String str1, String str2) {
        char[] s1, s2; // s1 >= s2
        if (str1.length() >= str2.length()) {
            s1 = str1.toCharArray();
            s2 = str2.toCharArray();
        } else {
            s1 = str2.toCharArray();
            s2 = str1.toCharArray();
        }

        int n = s1.length;
        int m = s2.length;
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int leftup = 0;
            int backup;
            for (int j = 1; j <= m; j++) {
                backup = dp[j];
                if (s1[i - 1] == s2[j - 1]) {
                    dp[j] = 1 + leftup;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                leftup = backup;
            }
        }
        return dp[m];
    }

    public int longestCommonSubsequenceUsing2D(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public int longestCommonSubsequenceUsingMemorization(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        lcs(text1, text2, 0, 0, dp);
        return dp[0][0];
    }


    private int lcs(String text1, String text2, int i, int j, int[][] dp) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxLength;
        if (text1.charAt(i) == text2.charAt(j)) {
            maxLength = 1 + lcs(text1, text2, i + 1, j + 1, dp);
        } else {
            maxLength = Math.max(lcs(text1, text2, i + 1, j, dp), lcs(text1, text2, i, j + 1, dp));
        }

        dp[i][j] = maxLength;
        return maxLength;
    }
}
