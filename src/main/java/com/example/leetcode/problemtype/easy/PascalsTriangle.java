package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * Example 1:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: numRows = 1
 * Output: [[1]]
 * <p>
 * Leetcode link : https://leetcode.com/problems/pascals-triangle/description/
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(0, 1);
            for (int j = 1; j < i; j++) {
                row.add(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i != 0) {
                row.add(i, 1);
            }
            result.add(i, row);
        }

        return result;

    }
}
