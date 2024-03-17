package com.example.leetcode.problemtype.easy;

/**
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
 * <p>
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * <p>
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
 * <p>
 * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 * <p>
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * <p>
 * Example 3:
 * <p>
 * Input: s = "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is either '(' or ')'.
 * s is a valid parentheses string.
 * <p>
 * Leetcode link : https://leetcode.com/problems/remove-outermost-parentheses/description/
 */
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        RemoveOutermostParentheses obj = new RemoveOutermostParentheses();
        String result = obj.removeOuterParentheses("(()())(())");
        System.out.println(result);

    }

    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {

            if (c == '(' && count++ > 0) result.append(c);
            if (c == ')' && count-- > 1) result.append(c);
        }
        return result.toString();

    }
}
