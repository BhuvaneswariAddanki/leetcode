package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a sentence text (A sentence is a string of space-separated words) in the following format:
 * <p>
 * First letter is in upper case.
 * Each word in text are separated by a single space.
 * <p>
 * Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.
 * <p>
 * Return the new text following the format shown above.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "Leetcode is cool"
 * Output: "Is cool leetcode"
 * Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
 * Output is ordered by length and the new first word starts with capital letter.
 * <p>
 * Example 2:
 * <p>
 * Input: text = "Keep calm and code on"
 * Output: "On and keep calm code"
 * Explanation: Output is ordered as follows:
 * "On" 2 letters.
 * "and" 3 letters.
 * "keep" 4 letters in case of tie order by position in original text.
 * "calm" 4 letters.
 * "code" 4 letters.
 * <p>
 * Example 3:
 * <p>
 * Input: text = "To be or not to be"
 * Output: "To be or to be not"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * text begins with a capital letter and then contains lowercase letters and single space between words.
 * 1 <= text.length <= 10^5
 * <p>
 * Leetcode link : https://leetcode.com/problems/rearrange-words-in-a-sentence/description/
 */
public class RearrangeWordsInASentence {

    public static void main(String[] args) {
        String text = "Leetcode is cool";
        RearrangeWordsInASentence obj = new RearrangeWordsInASentence();
        String result = obj.arrangeWords(text);
        System.out.println(result);
    }

    public String arrangeWords(String text) {

        text = text.toLowerCase();
        String[] subStrings = text.split(" ");

        Map<Integer, List<String>> map = new TreeMap<>(Integer::compareTo);

        for (String subString : subStrings) {
            List<String> subStringList = map.getOrDefault(subString.length(), new LinkedList<>());
            subStringList.add(subString);
            map.put(subString.length(), subStringList);
        }
        StringBuilder result = new StringBuilder();
        map.forEach((key, val) -> {
            for (String subString : val) {
                result.append(subString).append(" ");
            }
        });
        result.deleteCharAt(result.length() - 1);
        result.replace(0, 1, result.substring(0, 1).toUpperCase());
        return result.toString();
    }

    public String arrangeWordsWithArray(String text) {
        String[] words = text.split(" ");
        words[0] = Character.toLowerCase(words[0].charAt(0)) + words[0].substring(1);
        int maxLen = 0;

        for (String word : words)
            maxLen = Math.max(maxLen, word.length());

        ArrayList<String>[] wordLenBuckets = new ArrayList[maxLen];

        for (String word : words) {
            int index = word.length() - 1;
            if (wordLenBuckets[index] == null)
                wordLenBuckets[index] = new ArrayList<>();

            wordLenBuckets[index].add(word);
        }
        StringBuilder sb = new StringBuilder();
        boolean seenFirstWord = false;
        for (ArrayList<String> wordBucket : wordLenBuckets) {
            if (wordBucket == null)
                continue;

            for (String word : wordBucket) {
                if (!seenFirstWord) {
                    sb.append(Character.toUpperCase(word.charAt(0)));
                    word = word.substring(1);
                    seenFirstWord = true;
                }
                sb.append(word);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
