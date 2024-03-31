package com.example.leetcode.problemtype.medium;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * <p>
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 * <p>
 * For example, the saying and conversion for digit string "3322251":
 * <p>
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 * <p>
 * Leetcode link : https://leetcode.com/problems/count-and-say/description/
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = count(result);
        }
        return result;
    }

    private static String count(String s) {
        StringBuilder response = new StringBuilder();
        int i = 1;
        char c = s.charAt(0);
        int count = 1;
        while (i < s.length()) {
            if (c == s.charAt(i)) {
                count++;
            } else {
                response.append(count).append(c);
                count = 1;
                c = s.charAt(i);
            }
            i++;
        }
        response.append(count).append(c);
        return response.toString();

    }
}
