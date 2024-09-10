package com.example.leetcode.problemtype.medium;

import java.util.Arrays;

/**
 * 97. Interleaving String
 * Medium
 * Topics
 * Companies
 * <p>
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m
 * substrings
 * respectively, such that:
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * <p>
 * Note: a + b is the concatenation of strings a and b.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Explanation: One way to obtain s3 is:
 * Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
 * Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
 * Since s3 can be obtained by interleaving s1 and s2, we return true.
 * <p>
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
 * <p>
 * Example 3:
 * <p>
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lowercase English letters.
 * <p>
 * <p>
 * <p>
 * Follow up: Could you solve it using only O(s2.length) additional memory space?
 * <p>
 * Leetcode link : https://leetcode.com/problems/interleaving-string/description/
 */
public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString obj = new InterleavingString();
        boolean res = obj.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(res);
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        return check(s1, s2, s3, 0, 0, dp);
    }

    private boolean check(String s1, String s2, String s3, int i1, int i2, int[][] dp) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return true;
        }

        if ( dp[i1][i2] != 0) {
            return dp[i1][i2] == 1;
        }
        boolean result = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2)) {
            result = check(s1, s2, s3, i1 + 1, i2, dp);
        }
        if (!result && i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2)) {
            result = check(s1, s2, s3, i1, i2 + 1, dp);
        }
        dp[i1][i2] = result ? 1 : -1;
        return result;
    }

}
