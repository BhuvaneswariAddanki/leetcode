package com.example.leetcode.problemtype.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * Easy
 * Topics
 * Companies
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * <p>
 * Leetcode link : https://leetcode.com/problems/isomorphic-strings/description/
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        // Base case: for different length of two strings...
        if (s.length() != t.length())
            return false;
        // Create two maps for s & t strings...
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        // Traverse all elements through the loop...
        for (int idx = 0; idx < s.length(); idx++) {
            // Compare the maps, if not equal, return false...
            if (map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;
            // Insert each character if string s and t into seperate map...
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;
        }
        return true;    // Otherwise return true...
    }

    public boolean isIsomorphic2(String s, String t) {
        // Base case: for different length of two strings...
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int idx = 0; idx < s.length(); idx++) {
            if (map1.containsKey(s.charAt(idx)) && map1.get(s.charAt(idx)) != t.charAt(idx)) {
                return false;

            }
            if (map2.containsKey(t.charAt(idx)) && map2.get(t.charAt(idx)) != s.charAt(idx)) {
                return false;
            }

            map1.put(s.charAt(idx), t.charAt(idx));
            map2.put(t.charAt(idx), s.charAt(idx));
        }
        return true;
    }
}
