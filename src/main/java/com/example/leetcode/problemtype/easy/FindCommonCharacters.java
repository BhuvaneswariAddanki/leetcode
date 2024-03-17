package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * <p>
 * Example 2:
 * <p>
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 * <p>
 * leetcode link : https://leetcode.com/problems/find-common-characters/description/
 */
public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) {
            map.put(A[0].charAt(i), map.getOrDefault(A[0].charAt(i), 0) + 1);
        }
        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < A[i].length(); j++) {
                if (map.containsKey(A[i].charAt(j))) {
                    temp.put(A[i].charAt(j),
                            Math.min(map.get(A[i].charAt(j)),
                                    temp.getOrDefault(A[i].charAt(j), 0) + 1));
                }
            }
            map = temp;
        }
        map.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                result.add(key + "");
            }
        });
        return result;
    }
}
