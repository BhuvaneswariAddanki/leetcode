package com.example.leetcode.problemtype.easy;

/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * <p>
 * Given a string word, return true if the usage of capitals in it is right.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word = "USA"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: word = "FlaG"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 * <p>
 * <p>
 * Leetcode link : https://leetcode.com/problems/detect-capital/description/
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        boolean allCaps = isCaps(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (isCaps(word.charAt(i))) {
                if (!allCaps) {
                    return false;
                }
            } else {
                if (allCaps && i > 1) {
                    return false;
                }
                allCaps = false;
            }
        }
        return true;

    }

    private boolean isCaps(char c) {
        return (c >= 65 && c <= 90);
    }
}
