package com.example.leetcode.problemtype.easy;

/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < n and n % x == 0.
 * Replacing the number n on the chalkboard with n - x.
 * <p>
 * Also, if a player cannot make a move, they lose the game.
 * <p>
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 * <p>
 * Leetcode link : https://leetcode.com/problems/divisor-game/description/
 */
public class DivisorGame {

    public boolean divisorGame(int n) {

        return n % 2 == 0;

    }
}
