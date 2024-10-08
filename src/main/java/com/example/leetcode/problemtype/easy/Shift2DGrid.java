package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 * <p>
 * In one shift operation:
 * <p>
 * Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * <p>
 * Return the 2D grid after applying shift operation k times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * <p>
 * Example 3:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * <p>
 * Leetcode link : https://leetcode.com/problems/shift-2d-grid/description/
 */
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList();
        int rows = grid.length, col = grid[0].length;

        for (int r = 0; r < rows; r++)// filling all the rows of result with empty lists
            result.add(new ArrayList());
        k %= (rows * col);// every rows*col shifts grid became the same, skipping the similar shifts
        int dimension = rows * col;
        int begin = dimension - k;// element at (begin) will be at 0,0 in new grid
        int x = 0;// counter variable
        for (int i = begin; i < begin + dimension; i++) {
            int r = (i / col) % rows, c = i % col;// calculating row and cell for new grid
            result.get(x / col).add(grid[r][c]);// adding new element in new row
            x++;
        }
        return result;// returning result list
    }
}
