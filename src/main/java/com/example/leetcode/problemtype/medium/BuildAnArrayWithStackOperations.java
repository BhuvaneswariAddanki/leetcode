package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array target and an integer n.
 * <p>
 * You have an empty stack with the two following operations:
 * <p>
 * "Push": pushes an integer to the top of the stack.
 * "Pop": removes the integer on the top of the stack.
 * <p>
 * You also have a stream of the integers in the range [1, n].
 * <p>
 * Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:
 * <p>
 * If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
 * If the stack is not empty, pop the integer at the top of the stack.
 * If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
 * <p>
 * Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = [1,3], n = 3
 * Output: ["Push","Push","Pop","Push"]
 * Explanation: Initially the stack s is empty. The last element is the top of the stack.
 * Read 1 from the stream and push it to the stack. s = [1].
 * Read 2 from the stream and push it to the stack. s = [1,2].
 * Pop the integer on the top of the stack. s = [1].
 * Read 3 from the stream and push it to the stack. s = [1,3].
 * <p>
 * Example 2:
 * <p>
 * Input: target = [1,2,3], n = 3
 * Output: ["Push","Push","Push"]
 * Explanation: Initially the stack s is empty. The last element is the top of the stack.
 * Read 1 from the stream and push it to the stack. s = [1].
 * Read 2 from the stream and push it to the stack. s = [1,2].
 * Read 3 from the stream and push it to the stack. s = [1,2,3].
 * <p>
 * Example 3:
 * <p>
 * Input: target = [1,2], n = 4
 * Output: ["Push","Push"]
 * Explanation: Initially the stack s is empty. The last element is the top of the stack.
 * Read 1 from the stream and push it to the stack. s = [1].
 * Read 2 from the stream and push it to the stack. s = [1,2].
 * Since the stack (from the bottom to the top) is equal to target, we stop the stack operations.
 * The answers that read integer 3 from the stream are not accepted.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target.length <= 100
 * 1 <= n <= 100
 * 1 <= target[i] <= n
 * target is strictly increasing.
 * <p>
 * Leetcode link : https://leetcode.com/problems/build-an-array-with-stack-operations/description/
 */
public class BuildAnArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {

        List<String> result = new ArrayList<>();
        int nextEle = 1;
        for (int ele : target) {
            while (ele != nextEle && nextEle <= n) {
                result.add("Push");
                result.add("Pop");
                nextEle++;
            }
            if (ele == nextEle) {
                result.add("Push");
            }
            nextEle++;
        }
        return result;
    }
}
