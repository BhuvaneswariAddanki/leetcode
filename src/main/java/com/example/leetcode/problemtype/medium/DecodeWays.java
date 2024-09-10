package com.example.leetcode.problemtype.medium;

import java.util.Arrays;

/**
 * 91. Decode Ways
 * Medium
 * Topics
 * Companies
 * <p>
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * <p>
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * <p>
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * <p>
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Example 2:
 * <p>
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * <p>
 * Example 3:
 * <p>
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 * <p>
 * Leetcode link : https://leetcode.com/problems/decode-ways/description/
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        // Initialize the DP array
        int single = 1; // There is one way to decode an empty string
        int doubleChar = 0;
        int res = 0;
        // Fill in the DP array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Check for leading zero
            if (s.charAt(i) == '0') {
                res = 0;
            } else {
                // Decode single digit
                res += single;

                // Decode two digits if possible
                if (i + 1 < n && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    res += doubleChar;
                }
            }
            doubleChar = single;
            single = res;
        }

        return res;
    }


    public int numDecodings2(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(s, 0, dp);
    }


    public int decode(String s, int index, int[] dp) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int count = decode(s, index + 1, dp);
        if (index < s.length() - 1 && ((s.charAt(index) == '1') || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {
            count += decode(s, index + 2, dp);
        }
        dp[index] = count;
        return count;
    }
}
