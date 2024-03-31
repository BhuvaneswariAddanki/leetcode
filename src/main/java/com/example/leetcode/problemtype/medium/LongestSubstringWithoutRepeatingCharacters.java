package com.example.leetcode.problemtype.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * Leetcode link : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int max = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // ex: abba
            if (indexMap.containsKey(s.charAt(i))) {
                j = Math.max(j, indexMap.get(s.charAt(i)) + 1);
            }
            indexMap.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);

        }
        return max;
    }

    public int lengthOfLongestSubstringUSingArray(String s) {
        int[] cache = new int[128];
        int max = 0;
        int start = 0;
        char[] seq = s.toCharArray();
        for (int i = 0; i < seq.length; i++) {
            start = Math.max(cache[seq[i]], start);
            max = Math.max(max, i - start + 1);
            cache[seq[i]] = i + 1;
        }
        return max;
    }
}
