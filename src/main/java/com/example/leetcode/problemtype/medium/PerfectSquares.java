package com.example.leetcode.problemtype.medium;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * <p>
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 104
 * <p>
 * Leetcode link : https://leetcode.com/problems/perfect-squares/description/
 */
public class PerfectSquares {


    // Time complexity: O(N * sqrt(N))
    // Space complexity: O(N)
    //Bottomup approach
    public int numSquaresUsingDpArray(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }

        return dp[n];
    }


    // Time complexity: O(N * sqrt(N))
    // Space complexity: O(N)
    public int numSquaresDPMemorization(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    public int helper(int n, int[] memo) {
        if (n < 4)
            return n;

        if (memo[n] != 0)
            return memo[n];

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + helper(n - square, memo));
        }

        return memo[n] = ans;
    }

    public int numSquaresBruteForce(int n) {
        if (n < 4)
            return n;

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + numSquaresBruteForce(n - square));
        }

        return ans;
    }

    // Time complexity: O(sqrt(N))
// Space complexity: O(1)

    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);

        if (sqrt * sqrt == n) // Perfect square
            return 1;

        while (n % 4 == 0) // 4^a (8b + 7)
            n = n / 4;

        if (n % 8 == 7)
            return 4;

        for (int i = 1; i * i <= n; i++) { // Sum of two perfect squares
            int square = i * i;
            int base = (int) Math.sqrt(n - square);

            if (base * base == n - square)
                return 2;
        }

        return 3;
    }
}
