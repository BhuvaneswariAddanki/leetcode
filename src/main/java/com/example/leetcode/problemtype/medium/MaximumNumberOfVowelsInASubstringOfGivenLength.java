package com.example.leetcode.problemtype.medium;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * <p>
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 * <p>
 * Leetcode link : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public int maxVowels(String s, int k) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = vowel(s.charAt(0));
        int max = count;
        for (int i = 1; i < s.length(); i++) {
            count = count + vowel(s.charAt(i)) - (i >= k ? vowel(s.charAt(i - k)) : 0);
            max = Math.max(max, count);
        }
        return max;

    }

    private int vowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return 1;
        }
        return 0;
    }

}
