package com.example.leetcode.problemtype.medium;

import java.util.Random;

/**
 * Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10]. You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.
 * <p>
 * Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing. Note that this is not an argument passed to rand10().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: [2]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: [2,8]
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: [3,8,10]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 105
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 * <p>
 * Leetcode link :https://leetcode.com/problems/implement-rand10-using-rand7/description/
 */
public class ImplementRand10UsingRand7 {
    public int rand10() {

        int result = 7 * (rand7() - 1) + (rand7() - 1);
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }

        return result % 10 + 1;
    }

    public int rand7() {
        return new Random().nextInt(8);
    }
}
