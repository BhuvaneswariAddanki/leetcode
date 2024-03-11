package com.example.leetcode.problemtype.easy;

/**
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello"
 * Output: "hello"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "here"
 * Output: "here"
 * <p>
 * Example 3:
 * <p>
 * Input: s = "LOVELY"
 * Output: "lovely"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of printable ASCII characters.
 * Leetcode link : https://leetcode.com/problems/to-lower-case/description/
 */
public class ToLowerCase {

    public String toLowerCase(String str) {

        String response = "";
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            response = response + (((int) a >= 65 && (int) a <= 90) ? (char) ((int) a + 32) : a);

        }
        return response;
    }
    public String toLowerCaseWithDirectAlphabets(String s) {
        char[] arr = s.toCharArray();
        for(int i=0;i< arr.length;i++){
            if('A' <= arr[i] && arr[i] <= 'Z'){
                arr[i] = (char) (arr[i]-'A'+'a');
            }
        }
        return new String(arr);
    }
}
