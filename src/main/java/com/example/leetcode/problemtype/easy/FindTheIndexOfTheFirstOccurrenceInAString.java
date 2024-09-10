package com.example.leetcode.problemtype.easy;

/**
 * 28. Find the Index of the First Occurrence in a String
 * Solved
 * Easy
 * Topics
 * Companies
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * <p>
 * <p>
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
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 * <p>
 * Leetcode link : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) {
            return 0; // If needle is empty, return 0
        }

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i; // Found the needle, return the starting index
            }
        }

        return -1; // Needle not found
    }

}
