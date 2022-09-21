package com.example.leetcode.sep17;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 * <p>
 * Return the number of pairs of different nodes that are unreachable from each other.
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 */
public class CountUnreachablePairs {

    List<List<Integer>> graph = new ArrayList<>();

    public long countPairs(int n, int[][] edges) {
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);  // make graph
            graph.get(edge[1]).add(edge[0]);
        }

        long result = 0, unvisitedNodes = n;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            if (!visited[i]) {
                int connectedCount = dfs(i, visited, new int[1]); // find size of connected component
                unvisitedNodes = unvisitedNodes - connectedCount;
                result += connectedCount * unvisitedNodes;
            }
        return result;
    }

    int dfs(int node, boolean[] visited, int[] count) {
        if (visited[node]) return count[0];
        visited[node] = true;
        count[0]++;
        for (int curr : graph.get(node))
            dfs(curr, visited, count);
        return count[0];
    }

}
