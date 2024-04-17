package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.
 * <p>
 * Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3, k = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2, k = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 9
 * 0 <= k <= 9
 * <p>
 * Leetcode link: https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/
 */
public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> result = new ArrayList<>();
        if (N == 1) {
            result.add(0);
        }

        for (int i = 1; i <= 9; i++) {
            result.addAll(validNumber(i, N - 1, K));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    private Set<Integer> validNumber(int num, int n, int k) {
        Set<Integer> partialResult = new HashSet<>();
        if (n == 0) {
            partialResult.add(num);
        } else {
            int currentDigit = num % 10;
            if (currentDigit + k <= 9) {
                int updatedNum = num * 10 + (currentDigit + k);
                partialResult.addAll(validNumber(updatedNum, n - 1, k));
            }
            if (currentDigit - k >= 0) {
                int updatedNum = num * 10 + (currentDigit - k);
                partialResult.addAll(validNumber(updatedNum, n - 1, k));
            }

        }
        return partialResult;
    }
}
