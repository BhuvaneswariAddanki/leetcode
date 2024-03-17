package com.example.leetcode.problemtype.easy;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * <p>
 * Example 2:
 * <p>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 * <p>
 * Leetcode link : https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int f1 = cost[0];
        int f2 = cost[1];
        int result = f2;
        for (int i = 2; i < cost.length; i++) {
            result = Math.min(f1, f2) + cost[i];
            f1 = f2;
            f2 = result;
        }
        return Math.min(f1, result);
    }
}
