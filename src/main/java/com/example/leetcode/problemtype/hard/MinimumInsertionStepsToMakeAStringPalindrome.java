package com.example.leetcode.problemtype.hard;

/**
 * Given a string s. In one step you can insert any character at any index of the string.
 *
 * Return the minimum number of steps to make s palindrome.
 *
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we do not need any insertions.
 *
 * Example 2:
 *
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 *
 * Example 3:
 *
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 500
 *     s consists of lowercase English letters.
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {

    }

    public int minInsertions(String s) {
        return s.length() - maxPalindromeLength(s);

    }

    private int maxPalindromeLength(String s){
        int max=0;
        for(int i=0;i<s.length();i++){
            int even = expandCenter(s,i,i+1);
            int odd = expandCenter(s,i,i);
            max = Math.max(max,Math.max(even,odd));
        }
        return max;
    }
    private int expandCenter(String s, int i,int j){
        int count =0;
        while(i>=0 && j< s.length()){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
                count++;
            }else{
                break;
            }


        }
        return j-i-1;
    }
}
