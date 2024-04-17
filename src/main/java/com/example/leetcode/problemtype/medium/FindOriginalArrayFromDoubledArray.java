package com.example.leetcode.problemtype.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.
 * <p>
 * Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: changed = [1,3,4,2,6,8]
 * Output: [1,3,4]
 * Explanation: One possible original array could be [1,3,4]:
 * - Twice the value of 1 is 1 * 2 = 2.
 * - Twice the value of 3 is 3 * 2 = 6.
 * - Twice the value of 4 is 4 * 2 = 8.
 * Other original arrays could be [4,3,1] or [3,1,4].
 * <p>
 * Example 2:
 * <p>
 * Input: changed = [6,3,0,1]
 * Output: []
 * Explanation: changed is not a doubled array.
 * <p>
 * Example 3:
 * <p>
 * Input: changed = [1]
 * Output: []
 * Explanation: changed is not a doubled array.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= changed.length <= 105
 * 0 <= changed[i] <= 105
 */
public class FindOriginalArrayFromDoubledArray {

    public static void main(String[] args) {
        int[] changed = new int[]{1, 3, 4, 2, 6, 8};
        FindOriginalArrayFromDoubledArray obj = new FindOriginalArrayFromDoubledArray();
        int[] result = obj.findOriginalArray(changed);
        for (int ele : result) {
            System.out.println(ele + "\t");
        }
    }

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1)
            return new int[]{};
        Arrays.sort(changed);
        int n = changed.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[n / 2];
        int k = 0;
        queue.offer(changed[0]);
        for (int i = 1; i < n; i++) {
            if (!queue.isEmpty() && (queue.peek() * 2) == changed[i]) {
                result[k++] = queue.peek();
                queue.remove();
            } else {
                queue.offer(changed[i]);
            }
        }
        return queue.isEmpty() ? result : new int[0];
    }
}
