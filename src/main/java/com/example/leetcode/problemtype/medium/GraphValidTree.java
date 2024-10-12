package com.example.leetcode.problemtype.medium;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * Example
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
 * <p>
 * Output: true.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
 * <p>
 * Output: false.
 */
public class GraphValidTree {

    private int[] rank;
    private int[] root;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        rank = new int[n];
        root = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }

        for (int[] edge : edges) {
            if (isCycle(edge[0], edge[1])) {
                return false;
            }
            union(edge[0], edge[1]);
        }
        return true;
    }


    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        root[x] = find(root[x]);
        return root[x];
    }

    public boolean isCycle(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
                rank[rootY]++;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
