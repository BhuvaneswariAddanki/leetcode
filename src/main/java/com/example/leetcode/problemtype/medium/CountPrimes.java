package com.example.leetcode.problemtype.medium;

import java.util.Arrays;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: 0
 * <p>
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 5 * 106
 * <p>
 * Leetcode link : https://leetcode.com/problems/count-primes/description/
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                for (int j = 2; j <= (n - 1) / i; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        if(n <= 1) return 0;
        int count =1;
        boolean[] unmarked = new boolean[n];
        Arrays.fill(unmarked, true);
        unmarked[0] = unmarked[1] = false;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(unmarked[i]){
                for(int j = i * i; j <n; j+=i){
                    if(unmarked[j]){
                        count++;
                        unmarked[j] = false;
                    }
                }
            }
        }

        return n - count -1;
    }
}
