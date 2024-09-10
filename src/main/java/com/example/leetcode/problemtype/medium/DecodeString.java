package com.example.leetcode.problemtype.medium;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 105.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * <p>
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 * Leetcode link : https://leetcode.com/problems/decode-string/description/
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strBuild = new Stack<>();
        StringBuilder str = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strBuild.push(str);
                str = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                StringBuilder temp = str;
                str = strBuild.pop();
                int count = numStack.pop();
                while (count-- > 0) {
                    str.append(temp);
                }
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}
