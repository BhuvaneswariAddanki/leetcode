package com.example.leetcode.problemtype.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 73. Set Matrix Zeroes
 * Medium
 * Topics
 * Companies
 * Hint
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * You must do it in place.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * <p>
 * Leetcode link : https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class SetMatrixZeroes {
    /**
     * Optimized In-Place solution
     * <p>
     * We can use the first cell of every row and column as a flag. This flag will
     * determine whether a row or a column has to be set to zero.
     * <p>
     * Time Complexity: O(2 * R * C)
     * <p>
     * Space Complexity: O(1)
     * <p>
     * R = Number of rows. C = Number of columns.
     */
    public void setZeroes2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 1 && cols == 1) {
            return;
        }

        boolean isFirstColZero = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (isFirstColZero) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        List<int[]> zerosList = new LinkedList<>();

        // Traverse the matrix to find zeros and store their coordinates in the linked list
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    zerosList.add(new int[]{row, col});
                }
            }
        }

        // Set zeros in the matrix based on the coordinates stored in the linked list
        for (int[] zero : zerosList) {
            int zeroRow = zero[0];
            int zeroCol = zero[1];

            // Set zeros in the row
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[zeroRow][col] = 0;
            }

            // Set zeros in the column
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][zeroCol] = 0;
            }
        }
    }
}
