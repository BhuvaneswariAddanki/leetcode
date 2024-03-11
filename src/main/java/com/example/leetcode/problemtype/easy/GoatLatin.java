package com.example.leetcode.problemtype.easy;

/**
 * You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
 * For example, the word "apple" becomes "applema".
 * If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
 * <p>
 * Return the final sentence representing the conversion from sentence to Goat Latin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sentence = "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * Example 2:
 * <p>
 * Input: sentence = "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= sentence.length <= 150
 * sentence consists of English letters and spaces.
 * sentence has no leading or trailing spaces.
 * All the words in sentence are separated by a single space.
 * <p>
 * Leetcode link : https://leetcode.com/problems/goat-latin/description/
 */
public class GoatLatin {

    public String toGoatLatin(String S) {

        String[] words = S.split(" ");
        String suffix = "a";
        StringBuilder response = new StringBuilder();
        for (String word : words) {
            if (startsWithVowel(word)) {
                response.append(word);
            } else {
                response.append(word.substring(1)).append(word.charAt(0));
            }

            response.append("ma").append(suffix).append(" ");
            suffix += "a";
        }
        String res = response.toString();

        return res.substring(0, res.length() - 1);

    }

    private boolean startsWithVowel(String word) {

        return word.length() >= 1 && (word.charAt(0) == 'a'
                || word.charAt(0) == 'A'
                || word.charAt(0) == 'e'
                || word.charAt(0) == 'E'
                || word.charAt(0) == 'i'
                || word.charAt(0) == 'I'
                || word.charAt(0) == 'o'
                || word.charAt(0) == 'O'
                || word.charAt(0) == 'u'
                || word.charAt(0) == 'U');


    }
}
