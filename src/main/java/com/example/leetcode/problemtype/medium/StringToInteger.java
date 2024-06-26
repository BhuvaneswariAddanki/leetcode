package com.example.leetcode.problemtype.medium;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "42" ("42" is read in)
 * ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 * ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 * ^
 * Step 3: "   -42" ("42" is read in)
 * ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 * ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 * <p>
 * Leetcode link : https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class StringToInteger {

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        int num = 0;
        if (str.isEmpty()) {
            return 0;
        }
        int index = 1;
        if (str.charAt(0) == '+' && str.length() > 1 && Character.isDigit(str.charAt(1))) {
            num = Character.getNumericValue(str.charAt(1));
            ;
            index++;
        } else if (str.charAt(0) == '-' && str.length() > 1 && Character.isDigit(str.charAt(1))) {
            num = -Character.getNumericValue(str.charAt(1));
            index++;
        } else if (Character.isDigit(str.charAt(0))) {
            num = Character.getNumericValue(str.charAt(0));
        } else {
            return 0;
        }
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int nextNum = Character.getNumericValue(str.charAt(index));
            if ((num > Integer.MAX_VALUE / 10) || (num == Integer.MAX_VALUE / 10 && nextNum > 7)) {
                return Integer.MAX_VALUE;
            }
            if ((num < Integer.MIN_VALUE / 10) || (num == Integer.MIN_VALUE / 10 && -nextNum < -8)) {
                return Integer.MIN_VALUE;
            }
            num = (num * 10) + (num < 0 ? -nextNum : nextNum);
            index++;
        }
        if (str.charAt(0) == '-' && num >= 0) {
            num = -num;

        }
        return num;
    }
}
