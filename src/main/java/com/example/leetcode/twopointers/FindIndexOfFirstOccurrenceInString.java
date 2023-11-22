package com.example.leetcode.twopointers;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * <p>
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * <p>
 * Example 2:
 * <p>
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class FindIndexOfFirstOccurrenceInString {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        FindIndexOfFirstOccurrenceInString obj = new FindIndexOfFirstOccurrenceInString();
        System.out.print("index : "+ obj.strStr(haystack,needle) );
    }
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int result = -1;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == 0) {
                    result = i;
                }
                if (j == needle.length() - 1) {
                    return result;
                }
                j++;
            } else {
                if (j > 0) {
                    j = 0;
                    i = result;
                }
            }
            i++;
        }
        return -1;
    }

}
