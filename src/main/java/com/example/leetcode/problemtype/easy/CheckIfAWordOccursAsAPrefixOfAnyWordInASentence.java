package com.example.leetcode.problemtype.easy;

/**
 * Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.
 * <p>
 * Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
 * <p>
 * A prefix of a string s is any leading contiguous substring of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sentence = "i love eating burger", searchWord = "burg"
 * Output: 4
 * Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
 * <p>
 * Example 2:
 * <p>
 * Input: sentence = "this problem is an easy problem", searchWord = "pro"
 * Output: 2
 * Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
 * <p>
 * Example 3:
 * <p>
 * Input: sentence = "i am tired", searchWord = "you"
 * Output: -1
 * Explanation: "you" is not a prefix of any word in the sentence.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence consists of lowercase English letters and spaces.
 * searchWord consists of lowercase English letters.
 * <p>
 * Leetcode link : https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/
 */
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
