package com.example.leetcode;

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
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateValidList(result, new StringBuilder(), 0, 0, n);
        return result;

    }

    private void generateValidList(List<String> result, StringBuilder curStr, int open, int close, int n) {

        if (curStr.length() == n * 2) {
            result.add(curStr.toString());
        } else {
            if (open < n) {
                curStr.append("(");
                generateValidList(result, curStr, open + 1, close, n);
                curStr.deleteCharAt(curStr.length() - 1);
            }
            if (close < open) {
                curStr.append(")");
                generateValidList(result, curStr, open, close + 1, n);
                curStr.deleteCharAt(curStr.length() - 1);
            }
        }
    }

}
