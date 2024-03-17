package com.example.leetcode.problemtype.easy;

/**
 * There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
 * <p>
 * For each location indices[i], do both of the following:
 * <p>
 * Increment all the cells on row ri.
 * Increment all the cells on column ci.
 * <p>
 * Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: m = 2, n = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
 * <p>
 * Example 2:
 * <p>
 * Input: m = 2, n = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 50
 * 1 <= indices.length <= 100
 * 0 <= ri < m
 * 0 <= ci < n
 * <p>
 * <p>
 * <p>
 * Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?
 * <p>
 * leetcode link: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/
 */
public class CellsWithOddValuesInAMatrix {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] index : indices) {
            int r = index[0];
            int c = index[1];
            for (int j = 0; j < m; j++) {
                matrix[r][j] += 1;
            }
            for (int j = 0; j < n; j++) {
                matrix[j][c] += 1;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * We have to count the cells that are incremented odd number of times.
     * The indices can be though of as a list of rows and columns to be incremented, represented by 0th and 1st index respectively.
     * <p>
     * Lets consider our row list as list of 0th element of each indices element.
     * column list as list of 1st element of each indices element.
     * <p>
     * There are four categories of cells. For a cell [i, j] it can be
     * 1. Not incremented at all. i does not belong to the row list and j does not belong the columns list. This has no contribution in the final odd count.
     * 2. Only incremented through some row increment operation. i belongs to the row list but j does not belong to the columns list.
     * 3. Only incremented through some column increment operation. i does not belong to the row list but j belongs to the columns list
     * 4. Incremented both by row and column increment operations. i belongs to the row list and j belongs to the columns list. These will contribute if overall increment is odd number of times.
     * <p>
     * Any rows or columns incremented even number of times will not have any effect on the number of odd cells.
     * Approach
     * <p>
     * First compute the number of rows that are incremented odd number of times through row increment operations. It is simply finding the frequency of each row index in the row list. Total number of such cells will be m times the number of such rows.
     * <p>
     * Next find the number of columns incremented odd number of times through the column increment operations. Total number of such cells will be n times the number of such columns.
     * <p>
     * Finally intersection of such rows and columns have to be subtracted 2 times because they will become even after incrementing odd times both through columns and through rows. 2 times because these are added in both row and column increment computation.
     * Complexity
     * <p>
     * Time complexity:
     * O(m+n+indicesSize)O(m + n + indicesSize)O(m+n+indicesSize) we have to iterate once through the indices, once through rows frequency and once through columns frequency.
     * <p>
     * Space complexity:
     * O(m+n)O(m + n)O(m+n) for storing the frequencies.
     *
     * @param m
     * @param n
     * @param indices
     * @return
     */

    public int oddCellsUsing2Arrays(int m, int n, int[][] indices) {
        if (indices == null || indices.length < 1 || indices[0].length != 2) {
            return 0;
        }
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int oddRows = 0;
        int oddCols = 0;
        for (int i = 0; i < m; i++) {
            if (row[i] % 2 == 1) {
                oddRows++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (col[j] % 2 == 1) {
                oddCols++;
            }
        }
        return (m - oddRows) * oddCols + (n - oddCols) * oddRows;
    }
}
