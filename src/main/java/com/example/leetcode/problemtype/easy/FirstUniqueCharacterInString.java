package com.example.leetcode.problemtype.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * <p>
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 * Leetcode link : https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharWithStringFunc(String s) {
        int ans = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {

            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                ans = Math.min(ans, index);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
