package com.example.leetcode.problemtype.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 * <p>
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
 * <p>
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 * <p>
 * Leetcode link : https://leetcode.com/problems/reformat-the-string/description/
 */
public class ReformatTheString {
    public String reformat(String s) {
        if (s.length() == 1)
            return s;

        StringBuilder sb = new StringBuilder();
        Deque<Character> letters = new ArrayDeque<>();
        Deque<Character> digits = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.push(ch);
            } else {
                digits.push(ch);
            }
        }

        //suppose stack1 size is 5 and second size is 4 then it will work eg covid (stack1) & 2019 (stack2)
        // return 5-4=1 but greater than 1 return false
        if (Math.abs(digits.size() - letters.size()) > 1)
            return "";

        while (!letters.isEmpty() && !digits.isEmpty()) {
            sb.append(letters.pop()).append(digits.pop());
        }

        if (!letters.isEmpty())
            sb.append(letters.pop());
        else if (!digits.isEmpty())
            sb.insert(0, digits.pop());

        return sb.toString();
    }
}
