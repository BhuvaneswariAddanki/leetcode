package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional path between garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.
 * <p>
 * All gardens have at most 3 paths coming into or leaving it.
 * <p>
 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.
 * <p>
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden. The flower types are denoted 1, 2, 3, or 4. It is guaranteed an answer exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3, paths = [[1,2]{2,3]{3,1]]
 * Output: [1,2,3]
 * Explanation:
 * Gardens 1 and 2 have different types.
 * Gardens 2 and 3 have different types.
 * Gardens 3 and 1 have different types.
 * Hence, [1,2,3] is a valid answer. Other valid answers include [1,2,4], [1,4,2], and [3,2,1].
 * <p>
 * Example 2:
 * <p>
 * Input: n = 4, paths = [[1,2]{3,4]]
 * Output: [1,2,1,2]
 * <p>
 * Example 3:
 * <p>
 * Input: n = 4, paths = [[1,2]{2,3]{3,4]{4,1]{1,3]{2,4]]
 * Output: [1,2,3,4]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * Every garden has at most 3 paths coming into or leaving it.
 * <p>
 * Leetcode link : https://leetcode.com/problems/flower-planting-with-no-adjacent/description/
 */
public class FlowerPlantingWithNoAdjacent {
    public static void main(String[] args) {
        //[[3,4]{4,5]{3,2]{5,1]{1,3]{4,2]]
        int[][] paths = new int[][]{{3, 4}, {4, 5}, {3, 2}, {5, 1}, {1, 3}, {4, 2}};
        FlowerPlantingWithNoAdjacent obj = new FlowerPlantingWithNoAdjacent();
        int[] response = obj.gardenNoAdj(5, paths);
        for (int val : response) {
            System.out.print(val + " ");
        }
    }

    public int[] gardenNoAdj2(int N, int[][] paths) {
        int[] colours = new int[N];
        Arrays.fill(colours, 1);
        boolean done = false;
        while (!done) {
            done = true;
            for (int[] edge : paths) {
                int i = edge[0];
                int j = edge[1];
                int min = Math.min(i, j);
                int max = Math.max(i, j);
                if (colours[max - 1] == colours[min - 1]) {
                    done = false;
                    colours[max - 1] = colours[min - 1] == 4 ? 1 : colours[min - 1] + 1;
                }
            }
        }
        return colours;
    }

    public int[] gardenNoAdj(int n, int[][] paths) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> plantMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> adjacentGardens = graph.get(i + 1);
            List<Integer> flowers = new ArrayList<>();
            flowers.add(1);
            flowers.add(2);
            flowers.add(3);
            flowers.add(4);

            for (Integer adjacent : adjacentGardens) {
                if (plantMap.containsKey(adjacent)) {
                    flowers.remove(plantMap.get(adjacent));
                }
            }
            plantFlower(plantMap, flowers, i + 1);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = plantMap.get(i + 1);
        }
        return result;

    }

    private void plantFlower(Map<Integer, Integer> result, List<Integer> flowers, Integer adjacent) {
        if (result.containsKey(adjacent)) {
            flowers.remove(result.get(adjacent));
        } else {
            result.put(adjacent, getOnePossibleFlower(flowers));
        }
    }

    private Integer getOnePossibleFlower(List<Integer> flowers) {
        if (!flowers.isEmpty()) {
            Integer nextFlower = flowers.get(0);
            flowers.remove(nextFlower);
            return nextFlower;
        }
        return null;
    }
}
