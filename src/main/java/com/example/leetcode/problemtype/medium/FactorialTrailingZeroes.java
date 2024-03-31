package com.example.leetcode.problemtype.medium;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 *
 * Example 3:
 *
 * Input: n = 0
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 104
 *
 * Leetcode link : https://leetcode.com/problems/factorial-trailing-zeroes/description/
 */
public class FactorialTrailingZeroes {
    /**
     * Intuition
     *
     * The problem seems to involve counting the number of trailing zeros in the factorial of a given number n.
     * Trailing zeros occur when the product of numbers includes factors of 5 and 2.
     * Since multiples of 2 are more frequent than multiples of 5,
     * counting the number of factors of 5 should be sufficient for this problem.
     * #### Approach ####
     * The approach used in the provided code is to iteratively divide n by 5 in a while loop
     * and accumulate the result in the res variable.
     * The idea is that each division by 5 accounts for one factor of 5 in the product, and the loop continues until n becomes less than 5.
     *
     * Here's a step-by-step breakdown of the code:
     *
     *     Initialize res to 0.
     *     Enter a while loop as long as n is greater than or equal to 5.
     *     Increment res by the result of n/5.
     *     Update n to n/5.
     *     Return the final value of res.
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int sum =0;
        while(n>0){
            sum+= n/5;
            n=n/5;
        }
        return sum;

    }
}
