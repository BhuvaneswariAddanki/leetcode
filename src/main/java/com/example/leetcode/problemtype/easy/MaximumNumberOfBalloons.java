package com.example.leetcode.problemtype.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189. Maximum Number of Balloons
 * Easy
 * Topics
 * Companies
 * Hint
 * <p>
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "nlaebolko"
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: text = "leetcode"
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text.length <= 104
 * text consists of lower case English letters only.
 * <p>
 * <p>
 * leetcode link : https://leetcode.com/problems/maximum-number-of-balloons/description/
 */
public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : text.toCharArray()) {
            if (isABalloonChar(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        return Math.min(Math.min(map.getOrDefault('o', 0) / 2, map.getOrDefault('l', 0) / 2),
                Math.min(Math.min(map.getOrDefault('a', 0), map.getOrDefault('b', 0)),
                        map.getOrDefault('n', 0)));

    }

    private boolean isABalloonChar(char ch) {
        return ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n';
    }


    public int maxNumberOfBalloons2(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0, occurrence = 0;
        char[] chars = text.toCharArray();

        for (char ch : chars) {
            switch (ch) {
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
                    break;
            }
        }

        return Math.min(Math.min(o / 2, l / 2), Math.min(Math.min(b, a), n));

    }
}
