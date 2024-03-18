package com.example.leetcode.problemtype.easy;

/**
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 * <p>
 * Given a string s, return the power of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters.
 * <p>
 * Leetcode link : https://leetcode.com/problems/consecutive-characters/description/
 */
public class ConsecutiveCharacters {

    public int maxPower(String s) {
        if (s == null) {
            return -1;
        }
        int maxCount = 0;
        int count = 0;
        int lastCharacter = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (lastCharacter != s.charAt(i)) {
                maxCount = Math.max(count, maxCount);
                count = 0;
                lastCharacter = s.charAt(i);
            } else {
                count++;
            }
        }
        return Math.max(count, maxCount);
    }
}
