package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 * Leetcode link : https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(3);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        //  generateValidList(result, "", 0, 0, n);
        generateValidListUsingStringBuilder(result, new StringBuilder(), 0, 0, n);
        return result;

    }

    private void generateValidList(List<String> result, String curStr, int open, int close, int n) {

        if (curStr.length() == n * 2) {
            result.add(curStr);
        } else {
            if (open < n) {
                generateValidList(result, curStr + "(", open + 1, close, n);
            }
            if (close < open) {
                generateValidList(result, curStr + ")", open, close + 1, n);
            }
        }
    }

    private void generateValidListUsingStringBuilder(List<String> result, StringBuilder curStr, int open, int close, int n) {

        if (curStr.length() == n * 2) {
            result.add(curStr.toString());
        } else {
            if (open < n) {
                curStr.append("(");
                generateValidListUsingStringBuilder(result, curStr, open + 1, close, n);
                curStr.deleteCharAt(curStr.length() - 1);
            }
            if (close < open) {
                curStr.append(")");
                generateValidListUsingStringBuilder(result, curStr, open, close + 1, n);
                curStr.deleteCharAt(curStr.length() - 1);
            }
        }
    }
}
