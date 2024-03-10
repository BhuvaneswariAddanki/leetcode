package com.example.leetcode.problemtype.easy;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * <p>
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindromeWithoutRegex(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (!isAlphaNumeric(s.charAt(j))) {
                j--;
            }
            if (!isAlphaNumeric(s.charAt(i))) {
                i++;
            }
            if (isAlphaNumeric(s.charAt(i))
                    && isAlphaNumeric(s.charAt(j))) {

                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }

            }
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}
