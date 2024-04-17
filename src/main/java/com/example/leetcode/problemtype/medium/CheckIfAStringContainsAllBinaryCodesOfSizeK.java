package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "00110110", k = 2
 * Output: true
 * Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "0110", k = 1
 * Output: true
 * Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "0110", k = 2
 * Output: false
 * Explanation: The binary code "00" is of length 2 and does not exist in the array.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 105
 * s[i] is either '0' or '1'.
 * 1 <= k <= 20
 * <p>
 * Leetcode link : https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

    int[] binaryArray = new int[]{0, 1};

    /**
     * Approach 1: HashSet
     * First, let's make sure we're on the same page regarding the simpler approach.
     * This approach involves adding all susbtrings of length k to a hashset and checking if the set has 2^k elements
     * (if you're confident with this, feel free to skip to approach 2).
     * <p>
     * Why does this work?
     * When you start thinking about an approach to the question,
     * you may first think of generating all possible binary values of length k,
     * putting them in a set and checking the input string if it's missing any of these values.
     * After drawing out a couple short examples, you may then realise that there's exactly 2^k values.
     * Awesome! The next thing to realise is that we can just add all substrings of our input string into a hashset.
     * If the set's size is equal to 2^k, we have all possible values.
     *
     * @param s
     * @param k
     * @return
     */
    public boolean hasAllCodesUsingHashSet(String s, int k) {

        int n = s.length();
        Set<String> subStrings = new HashSet<>();
        double no = Math.pow(2, k);
        if (k > n) {
            return false;
        }
        for (int i = 0; i <= n - k; i++) {

            subStrings.add(s.substring(i, i + k));
        }
        return no == subStrings.size();
    }


    public boolean hasAllCodes(String s, int k) {

        StringBuilder str = new StringBuilder();
        List<String> result = new ArrayList<>();
        recursive(result, str, k);
        for (String code : result) {
            if (!s.contains(code)) {
                return false;
            }
        }
        return true;
    }

    private void recursive(List<String> result, StringBuilder str, int k) {
        if (k == 0) {
            result.add(str.toString());
        } else {
            for (int j : binaryArray) {
                str.append(j);
                recursive(result, str, k - 1);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

}
