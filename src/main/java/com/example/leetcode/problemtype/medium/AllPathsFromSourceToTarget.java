package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * <p>
 * Example 2:
 * <p>
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 * <p>
 * Leetcode link : https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        AllPathsFromSourceToTarget obj = new AllPathsFromSourceToTarget();
        List<List<Integer>> result = obj.allPathsSourceTarget(graph);
        System.out.println(result);

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pathTillNow = new ArrayList<>();
        pathTillNow.add(0);
        findPath(graph, result, 0, pathTillNow);
        return result;

    }

    private void findPath(int[][] graph, List<List<Integer>> result, int currentVertex, List<Integer> pathTillNow) {
        for (int reachableVertex : graph[currentVertex]) {
            pathTillNow.add(reachableVertex);
            if (reachableVertex == graph.length - 1) {
                result.add(new ArrayList<>(pathTillNow));
            } else {
                findPath(graph, result, reachableVertex, pathTillNow);
            }
            pathTillNow.remove(Integer.valueOf(reachableVertex));
        }
    }

}
