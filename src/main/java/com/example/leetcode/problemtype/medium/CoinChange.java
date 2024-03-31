package com.example.leetcode.problemtype.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * Leetcode link : https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        //coins = [1,2,5], amount = 11
        int[] coins = new int[]{2, 5, 10, 1};
        CoinChange coinChange = new CoinChange();
        int result = coinChange.minCoins(coins, 27);
        System.out.println(result);
    }

    // Utility function for solving the minimum coins
    // problem
    public static int minCoinsUtil(int[] coins,
                                   int amount, int[] dp) {
        // Base case: If target value V is 0, no coins are
        // needed
        if (amount == 0)
            return 0;

        // If subproblem is already solved, return the
        // result from DP table
        if (dp[amount] != -1)
            return dp[amount];

        int minCount = Integer.MAX_VALUE;

        // Iterate over all coins and recursively solve for
        // sub problems
        for (int coin : coins) {
            if (coin <= amount) {
                // Recursive call to solve for remaining
                // value V - coins[i]
                int currentCount = minCoinsUtil(
                        coins, amount - coin, dp);

                // If the sub problem has a valid solution
                // and the total number of coins is smaller
                // than the current result, update the
                // result
                if (currentCount != Integer.MAX_VALUE
                        && currentCount + 1 < minCount)
                    minCount = currentCount + 1;
            }
        }

        // Save the result in the DP table
        dp[amount] = minCount;

        return minCount;
    }

    // Function to find the minimum number of coins needed
    // to make a target value
    public static int minCoins(int[] coins, int amount) {
        // Create a DP table to store results of sub problems
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1); // Initialize DP table with -1

        // Call the utility function to solve the problem
        return minCoinsUtil(coins, amount, dp);
    }


}
