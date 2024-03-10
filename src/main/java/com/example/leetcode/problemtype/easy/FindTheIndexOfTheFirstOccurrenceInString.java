package com.example.leetcode.problemtype.easy;

/**
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
public class FindTheIndexOfTheFirstOccurrenceInString {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "pi";
        int result = new FindTheIndexOfTheFirstOccurrenceInString().strStr(haystack, needle);
        System.out.println(result);
    }

    public int strStrWithSlidingWindow(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        StringBuilder window = new StringBuilder();
        for (int i = 0; i < haystack.length(); i++) {
            if (window.length() == needle.length()) window.deleteCharAt(0);
            window.append(haystack.charAt(i));
            if (window.toString().equals(needle)) return i - needle.length() + 1;
        }
        return window.toString().equals(needle) ? 0 : -1;
    }

    public int usingSubstringWithSlidingWindow(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }
        return -1;
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
