package com.example.leetcode.problemtype.medium;

import static java.lang.Math.min;

/**
 * 221. Maximal Square
 * Medium
 * Topics
 * Companies
 * <p>
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: matrix = [["0"]]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 * <p>
 * Leetcode link : https://leetcode.com/problems/maximal-square/description/
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
        int s = 0;
        int[] dp = new int[c + 1];
        for (char[] chars : matrix) {
            int temp = 0;
            for (int j = 1; j <= c; j++) {
                int pre = dp[j];
                if (chars[j - 1] == '1') {
                    dp[j] = 1 + Math.min(dp[j], min(temp, dp[j - 1]));
                    s = Math.max(s, dp[j]);
                } else {
                    dp[j] = 0;
                }
                temp = pre;
            }
        }
        return s * s;
    }

    public int maximalSquare2(char[][] matrix) {
        int r=matrix.length;
        if(r==0) return 0;
        int c=matrix[0].length,edge=0;
        int[][] dp=new int[r+1][c+1];
        for(int i=1;i<=r;i++)
            for(int j=1;j<=c;j++) {
                if(matrix[i-1][j-1]=='0') continue;
                dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                edge=Math.max(edge,dp[i][j]);
            }
        return edge*edge;
    }
}
