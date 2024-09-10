package com.example.leetcode.problemtype.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * <p>
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * <p>
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * <p>
 * At the end of the game, there is at most one stone left.
 * <p>
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 * <p>
 * Example 2:
 * <p>
 * Input: stones = [1]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * <p>
 * Leetcode link : https://leetcode.com/problems/last-stone-weight/description/
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int w = lastStoneWeight.lastStoneWeight(stones);
        System.out.println(w);
    }

    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int i = stones.length - 1;
        while (i > 0) {
            if (stones[i] != stones[i - 1]) {
                stones[i - 1] = stones[i] - stones[i - 1];
                i = i - 1;
                Arrays.sort(stones,0,i+1);
            } else {
                i = i - 2;
            }
        }
        return i == 0 ? stones[0] : 0;
    }

    public int lastStoneWeightUsingPQ(int[] stones) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        while (priorityQueue.size() > 1) {
            int y = priorityQueue.remove();
            int x = priorityQueue.remove();
            if (x != y) {
                priorityQueue.offer(y - x);
            }
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.remove();

    }
}
