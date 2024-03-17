package com.example.leetcode.problemtype.easy;

/**
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 * <p>
 * Given a balanced string s, split it into some number of substrings such that:
 * <p>
 * Each substring is balanced.
 * <p>
 * Return the maximum number of balanced strings you can obtain.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
 * Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= s.length <= 1000
 * s[i] is either 'L' or 'R'.
 * s is a balanced string.
 * <p>
 * Leetcode link : https://leetcode.com/problems/split-a-string-in-balanced-strings/description/
 */
public class SplitAStringInBalancedStrings {

    public int balancedStringSplitUsingSingleCounter(String s) {
        int counter = 0;
        int result = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == 'L') {
                counter++;
            } else if (ch == 'R') {
                counter--;
            }
            if (counter == 0) {
                result++;
            }
        }
        return result;
    }

    public int balancedStringSplit(String s) {
        int counterOfR = 0;
        int counterOfL = 0;
        int result = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == 'L') {
                counterOfL++;
            } else if (ch == 'R') {
                counterOfR++;
            }
            if (counterOfL == counterOfR) {
                result++;
                counterOfL = 0;
                counterOfR = 0;
            }
        }
        return result;
    }
}
