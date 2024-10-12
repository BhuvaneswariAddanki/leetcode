package com.example.leetcode.problemtype.medium;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * <p>
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 7
 * Output: 28
 * <p>
 * Example 2:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 100
 * <p>
 * <p>
 * Leetcode link : https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        findPaths(0, 0, m, n, dp);
        return dp[0][0];

    }

    private int findPaths(int i, int j, int m, int n, int[][] dp) {
        if (i <= m - 1 && j <= n - 1) {
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (i == m - 1 && j == n - 1) {
                return 1;
            }
            int path1 = findPaths(i + 1, j, m, n, dp);
            int path2 = findPaths(i, j + 1, m, n, dp);
            dp[i][j] = path1 + path2;
            return path1 + path2;
        }
        return 0;
    }

}
