package com.example.leetcode.sep17;

import java.util.*;

/**
 * An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.
 * <p>
 * Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.
 * <p>
 * https://leetcode.com/problems/find-original-array-from-doubled-array/
 */
public class FindOriginalArrayFromDoubledArray {
    public static void main(String[] args) {

    }

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1)
            return new int[]{};
        Arrays.sort(changed);
        int i = 0;
        int[] result = new int[changed.length / 2];
        Queue<Integer> queue = new LinkedList<>();
        for (int num : changed) {
            if (!queue.isEmpty() && queue.peek() == num) {
                result[i++] = queue.poll() / 2;
            } else {
                queue.offer(num * 2);
            }
        }
        return queue.isEmpty() ? result : new int[]{};
    }
}
