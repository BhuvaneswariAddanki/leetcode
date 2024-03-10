package com.example.leetcode.problemtype.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * ASGFF Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 * Leetcode link :
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        String prefix = "";
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            boolean match = true;
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (!match) {
                break;
            } else {
                prefix = prefix + c;
            }
        }

        return prefix;
    }

}
