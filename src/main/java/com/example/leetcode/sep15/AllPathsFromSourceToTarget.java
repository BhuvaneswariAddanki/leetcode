package com.example.leetcode.sep15;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        AllPathsFromSourceToTarget obj = new AllPathsFromSourceToTarget();
        int[][] g = new int[][]{{1, 2}, {3}, {3}, {}};
        List<List<Integer>> response = obj.allPathsSourceTarget(g);
        System.out.println(response);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        findPath(0, graph, list, result);
        return result;
    }

    private void findPath(int i, int[][] graph, List<Integer> list, List<List<Integer>> result) {
        for (int j = 0; j < graph[i].length; j++) {
            list.add(graph[i][j]);
            if (graph[i][j] == graph.length - 1) {
                result.add(new ArrayList<>(list));
            } else {
                findPath(graph[i][j], graph, list, result);
            }
            list.remove(list.size()-1);
        }
    }
}
