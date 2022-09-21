package com.example.leetcode;

import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()[]{}"));
    }

    public boolean isValid(String s) {

        Map<Character, Character> charMap = Map.of('(', ')', '{', '}', '[', ']');
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (charStack.isEmpty()) {
                charStack.push(s.charAt(i));
            } else if (null != charMap.get(charStack.peek()) && charMap.get(charStack.peek()) == s.charAt(i)) {
                charStack.pop();
            } else {
                charStack.push(s.charAt(i));
            }
        }
        return charStack.isEmpty();
    }

    public boolean isValidWithoutMap(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                Character peeked = stack.peek();
                if (peeked == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else if (peeked == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else if (peeked == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();

    }
}
