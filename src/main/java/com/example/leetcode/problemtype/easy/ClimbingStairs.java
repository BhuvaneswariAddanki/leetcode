package com.example.leetcode.problemtype.easy;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f2;

    }

}
