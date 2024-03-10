package com.example.leetcode;

import java.util.Arrays;

/**
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        String reverseString = reverse(s);
        String[] words = reverseString.split(" ");
        StringBuilder result = new StringBuilder();
        return result.toString();
    }

    public String reverse(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return Arrays.toString(charArray);
    }
}
