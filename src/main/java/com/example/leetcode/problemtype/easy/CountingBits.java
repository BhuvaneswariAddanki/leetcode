package com.example.leetcode.problemtype.easy;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 105
 *
 *
 *
 * Follow up:
 *
 *     It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 *
 * Leetcode link : https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {

    /**
     * https://leetcode.com/problems/counting-bits/solutions/3987211/fast-simple-accepted-java-code-beats-90/
     * @param n
     * @return
     */
    public int[] countBits(int n) {

        int[] result = new int[n + 1];
        int pow = 1;
        for (int i = 1, t = 0; i <= n; i++, t++) {
            if (i == pow) {
                pow *= 2;
                t = 0;
            }
            result[i] = result[t] + 1;
        }
        return result;

    }
}
