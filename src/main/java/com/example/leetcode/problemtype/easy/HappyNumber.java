package com.example.leetcode.problemtype.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * <p>
 * Return true if n is a happy number, and false if not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 * <p>
 * Leetcode link : https://leetcode.com/problems/happy-number/description/
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = sum(n);
        int fast = sum(slow);
        while (slow != fast) {
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
        }
        return slow == 1;
    }

    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappyWithSet(int n) {

        Set<Integer> prev = new HashSet<>();

        while (n != 1) {
            int sumx = sum(n);
            n = sumx;
            if (prev.contains(sumx)) {
                return false;
            }
            prev.add(sumx);
        }

        return true;

    }

}
