package com.example.leetcode.problemtype.easy;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 105
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 * <p>
 * Leetcode link : https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {

    /**
     * https://leetcode.com/problems/counting-bits/solutions/3987211/fast-simple-accepted-java-code-beats-90/
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {

        int[] result = new int[n + 1];
        int pow = 1;
        int t = 0;
        for (int i = 1; i <= n; i++) {
            if (i == pow) { // next Binary Cycle
                pow *= 2;
                t = 0; // index used to Reuse arr
            }
            result[i] = result[t++] + 1;
        }
        return result;

    }

    public int[] countBits2(int n) {

        int[] result = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (i == offset * 2) {
                offset = i;
            }
            result[i] = result[i - offset] + 1;
        }
        return result;

    }
}
