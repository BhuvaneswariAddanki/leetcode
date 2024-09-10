package com.example.leetcode.problemtype.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * Easy
 * Topics
 * Companies
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 * <p>
 * Leetcode link : https://leetcode.com/problems/word-pattern/description/
 */
public class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, s));
    }


    public boolean wordPattern2(String pattern, String s) {
        String[] word = s.split(" ");
        if(word.length != pattern.length()) return false;

        HashMap<Character, String> map = new HashMap();
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);

            if(map.containsKey(c)){
                if(!map.get(c).equals(word[i])){
                    //char ke saath mapped word match mahi huya
                    return false;
                }
            }else {
                if(map.containsValue(word[i])){
                    //word already mapped hai kisi aur char ke saath
                    return false;
                }
                map.put(c, word[i]);
            }
        }

        return true;
    }
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        if(words.length !=pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if ((map1.containsKey(words[i]) && map1.get(words[i]) != pattern.charAt(i))
                    || (map2.containsKey(pattern.charAt(i)) && !words[i].equals(map2.get(pattern.charAt(i))))) {
                return false;
            }
            map1.put(words[i], pattern.charAt(i));
            map2.put(pattern.charAt(i), words[i]);
        }
        return true;

    }

}
