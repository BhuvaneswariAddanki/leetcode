package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * Medium
 * Topics
 * Companies
 * Hint
 * <p>
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 * <p>
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * <p>
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * <p>
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * <p>
 * It's guaranteed that each city can reach city 0 after reorder.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * <p>
 * Example 2:
 * <p>
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 5 * 104
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * <p>
 * Leetcode link : https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(-connection[0]);
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        vis[0] = true;
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            for (int neighbour : adj.get(Math.abs(curr))) {
                if (!vis[Math.abs(neighbour)]) {
                    qu.add(neighbour);
                    vis[Math.abs(neighbour)] = true;
                    if (neighbour > 0)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
