package com.example.leetcode.problemtype.easy;

/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 * <p>
 * <p>
 * Follow up: Could you find an O(n + m) solution?
 * leetcode link : https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */
public class CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {
        int count = 0;
        int nextLow = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            int low = nextLow;
            int high = grid[i].length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (grid[i][mid] < 0) {
                    count += high - mid + 1;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                    nextLow = mid + 1;

                }
            }

        }
        return count;
    }
}
