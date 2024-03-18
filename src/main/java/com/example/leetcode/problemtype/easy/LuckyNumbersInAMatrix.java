package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * <p>
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * <p>
 * Example 3:
 * <p>
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 * Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 105.
 * All elements in the matrix are distinct.
 * Leetcode link : https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
 */
public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int[] value : matrix) {

            int min = Integer.MAX_VALUE;
            int column = -1;

            for (int j = 0; j < value.length; j++) {

                if (min > value[j]) {
                    column = j;
                    min = value[j];
                }

            }
            int count = 0;
            for (int[] ints : matrix) {

                if (min >= ints[column]) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == matrix.length) {
                result.add(min);
            }
        }
        return result;
    }
}
