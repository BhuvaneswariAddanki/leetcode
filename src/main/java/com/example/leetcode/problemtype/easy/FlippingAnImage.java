package com.example.leetcode.problemtype.easy;

/**
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.
 * <p>
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * <p>
 * For example, inverting [0,1,1] results in [1,0,0].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == image.length
 * n == image[i].length
 * 1 <= n <= 20
 * images[i][j] is either 0 or 1.
 * <p>
 * Leetcode link : https://leetcode.com/problems/flipping-an-image/description/
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            for (int i = 0, j = row.length - 1; i <= j; i++, j--) {
                int temp = row[i];
                row[i] = reverse(row[j]);
                row[j] = reverse(temp);
            }
        }
        return image;
    }

    private int reverse(int num) {
        return num == 1 ? 0 : 1;
    }
}
