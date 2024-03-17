package com.example.leetcode.problemtype.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "azxxzy"
 * Output: "ay"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * Leetcode link : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 */
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicatesUsingStack(String s) {

        Deque<Character> characterDeque = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {

            if (!characterDeque.isEmpty() && characterDeque.peek().equals(ch)) {
                characterDeque.pop();
            } else {
                characterDeque.push(ch);
            }

        }
        char[] result = new char[characterDeque.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = characterDeque.pop();
        }
        return String.valueOf(result);

    }

    public String removeDuplicates(String s) {

        int index = -1;
        char[] result = s.toCharArray();
        for (Character ch : result) {
            if (index >= 0 && ch.equals(result[index])) {
                index--;
            } else {
                result[++index] = ch;
            }
        }
        return String.valueOf(result, 0, index + 1);
    }
}
