package com.example.leetcode.problemtype.medium;

/**
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
 * <p>
 * A string is called balanced if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB, where both A and B are balanced strings, or
 * It can be written as [C], where C is a balanced string.
 * <p>
 * You may swap the brackets at any two indices any number of times.
 * <p>
 * Return the minimum number of swaps to make s balanced.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "][]["
 * Output: 1
 * Explanation: You can make the string balanced by swapping index 0 with index 3.
 * The resulting string is "[[]]".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "]]][[["
 * Output: 2
 * Explanation: You can do the following to make the string balanced:
 * - Swap index 0 with index 4. s = "[]][][".
 * - Swap index 1 with index 5. s = "[[][]]".
 * The resulting string is "[[][]]".
 * <p>
 * Example 3:
 * <p>
 * Input: s = "[]"
 * Output: 0
 * Explanation: The string is already balanced.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == s.length
 * 2 <= n <= 106
 * n is even.
 * s[i] is either '[' or ']'.
 * The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
 * <p>
 * Leetcode link : https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    public int minSwaps(String s) {
        int extraClosing = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                extraClosing++;
            } else {
                extraClosing--;
            }
            max = Math.max(max, extraClosing);

        }
        return (max + 1) / 2;
    }

    public int minSwaps2(final String s) {
        int minSwaps = 0;
        int bracketsDifference = 0;

        for(var c : s.getBytes()){
            bracketsDifference += c == '[' ? 1 : -1;
            if(bracketsDifference < 0){
                bracketsDifference += 2;
                minSwaps++;
            }
        }

        return minSwaps;
    }
}
