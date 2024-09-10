package com.example.leetcode.problemtype.easy;

/**
 * 374. Guess Number Higher or Lower
 * Easy
 * Topics
 * Companies
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * <p>
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * <p>
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * <p>
 * Return the number that I picked.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10, pick = 6
 * Output: 6
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1, pick = 1
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: n = 2, pick = 1
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 * <p>
 * Leetcode link : https://leetcode.com/problems/guess-number-higher-or-lower/description/
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {

        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int guessRes = guess(mid);
            if (guessRes == 0) {
                return mid;
            } else if (guessRes < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    private int guess(int num) {
        /**
         * You call a pre-defined API int guess(int num), which returns three possible results:
         *
         *     -1: Your guess is higher than the number I picked (i.e. num > pick).
         *     1: Your guess is lower than the number I picked (i.e. num < pick).
         *     0: your guess is equal to the number I picked (i.e. num == pick).
         *
         * Return the number that I picked.
         */

        return -1;

    }


}
