package com.example.leetcode.problemtype.easy;

/**
 * 605. Can Place Flowers
 * Easy
 * Topics
 * Companies
 * <p>
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 * <p>
 * Leetcode link : https://leetcode.com/problems/can-place-flowers/description/
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] != 1) && (i == flowerbed.length - 1 || flowerbed[i + 1] != 1)) {
                flowerbed[i] = 1;
                count++;
                if (count == n) {
                    return true;
                }
            }
        }
        return false;

    }
}
