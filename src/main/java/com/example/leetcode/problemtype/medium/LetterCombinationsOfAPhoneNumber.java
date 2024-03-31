package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * <p>
 * Leetcode link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
        List<String> result = obj.letterCombinations("23");
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Character, String> dailMap = constructDialMap();
        List<String> prev = new ArrayList<>();
        prev.add("");
        for (int i = 1; i <= digits.length(); i++) {
            List<String> current = new ArrayList<>();
            for (String s : prev) {
                for (Character ch : dailMap.get(digits.charAt(i - 1)).toCharArray()) {
                    current.add(s + ch);
                }
            }
            prev = current;
        }

        return prev;
    }

    private Map<Character, String> constructDialMap() {
        Map<Character, String> dailMap = new HashMap<>();
        dailMap.put('2', "abc");
        dailMap.put('3', "def");
        dailMap.put('4', "ghi");
        dailMap.put('5', "jkl");
        dailMap.put('6', "mno");
        dailMap.put('7', "pqrs");
        dailMap.put('8', "tuv");
        dailMap.put('9', "wxyz");
        return dailMap;
    }

    StringBuilder s;
    List<String> ret;
    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinationsUsingRecursion(String digits) {
        ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        s = new StringBuilder();
        ret = new ArrayList<>();
        backTracing(digits, 0);
        return ret;
    }

    public void backTracing(String digits, int index) {
        if (index == digits.length()) {
            ret.add(s.toString());
            return;
        }
        String tmp = map[digits.charAt(index) - '0'];
        for (int i = 0; i < tmp.length(); i++) {
            s.append(tmp.charAt(i));
            backTracing(digits, index + 1);
            s.deleteCharAt(s.length() - 1);
        }

    }
}
