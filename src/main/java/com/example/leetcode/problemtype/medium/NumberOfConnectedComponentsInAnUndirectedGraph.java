package com.example.leetcode.problemtype.medium;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * Medium
 * Topics
 * Companies
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 * <p>
 * Return the number of connected components in the graph.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 * Example 2:
 * <p>
 * <p>
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 2000
 * 1 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai <= bi < n
 * ai != bi
 * There are no repeated edges.
 * <p>
 * Leetcode  link : https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    /**
     * ✔️ Solution 1a: Naive Union-Find ~ 3ms
     * <p>
     * class Solution {
     * public int countComponents(int n, int[][] edges) {
     * int[] parent = new int[n];
     * for (int i = 0; i < n; i++) parent[i] = i;
     * int components = n;
     * for (int[] e : edges) {
     * int p1 = findParent(parent, e[0]);
     * int p2 = findParent(parent, e[1]);
     * if (p1 != p2) {
     * parent[p1] = p2; // Union 2 component
     * components--;
     * }
     * }
     * return components;
     * }
     * private int findParent(int[] parent, int i) {
     * while (i != parent[i]) i = parent[i];
     * return i; // Without Path Compression
     * }
     * }
     * Complexity:
     * <p>
     * Time: O(n*m), where m is the number of connections, n is the number of nodes.
     * Space: O(n)
     * ✔️ Solution 1b: Union-Find with Path Compression ~ 1ms
     * <p>
     * class Solution {
     * public int countComponents(int n, int[][] edges) {
     * int[] parent = new int[n];
     * for (int i = 0; i < n; i++) parent[i] = i;
     * int components = n;
     * for (int[] e : edges) {
     * int p1 = findParent(parent, e[0]);
     * int p2 = findParent(parent, e[1]);
     * if (p1 != p2) {
     * parent[p1] = p2; // Union 2 component
     * components--;
     * }
     * }
     * return components;
     * }
     * private int findParent(int[] parent, int i) {
     * if (i == parent[i]) return i;
     * return parent[i] = findParent(parent, parent[i]); // Path compression
     * }
     * }
     * Complexity:
     * <p>
     * Time: O(n+mlogn), where m is the number of connections, n is the number of nodes.
     * By doing Path Compression, it has been proven to achieve in O(logN) in each operations. Read more under https://cp-algorithms.com/data_structures/disjoint_set_union.html#toc-tgt-2
     * Space: O(n)
     * ✔️ Solution 1c: Union-Find with Path Compression and Union by Size ~ 1ms
     * <p>
     * class Solution {
     * public int countComponents(int n, int[][] edges) {
     * int[] parent = new int[n];
     * int[] size = new int[n];
     * for (int i = 0; i < n; i++) {
     * parent[i] = i;
     * size[i] = 1;
     * }
     * int components = n;
     * for (int[] e : edges) {
     * int p1 = findParent(parent, e[0]);
     * int p2 = findParent(parent, e[1]);
     * if (p1 != p2) {
     * if (size[p1] < size[p2]) { // Merge small size to large size
     * size[p2] += size[p1];
     * parent[p1] = p2;
     * } else {
     * size[p1] += size[p2];
     * parent[p2] = p1;
     * }
     * components--;
     * }
     * }
     * return components;
     * }
     * private int findParent(int[] parent, int i) {
     * if (i == parent[i]) return i;
     * return parent[i] = findParent(parent, parent[i]); // Path compression
     * }
     * }
     * Complexity:
     * <p>
     * Time: O(n + m*α(n)) ≈ O(n + m), where m is the number of connections (union operations), n is the number of nodes.
     * Explanation: Using both path compression and union by size ensures that the amortized time per operation is only α(n), which is optimal, where α(n) is the inverse Ackermann function. This function has a value α(n) < 5 for any value of n that can be written in this physical universe, so the disjoint-set operations take place in essentially constant time.
     * Reference: https://en.wikipedia.org/wiki/Disjoint-set_data_structure or https://www.slideshare.net/WeiLi73/time-complexity-of-union-find-55858534 for more information.
     * <p>
     * Space: O(n)
     * ✔️ Solution 2: DFS ~ 3ms
     * <p>
     * class Solution {
     * public int countComponents(int n, int[][] edges) {
     * List<Integer>[] graph = new List[n];
     * for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
     * for (int[] e : edges) {
     * graph[e[0]].add(e[1]);
     * graph[e[1]].add(e[0]);
     * }
     * int components = 0;
     * boolean[] visited = new boolean[n];
     * for (int v = 0; v < n; v++) components += dfs(v, graph, visited);
     * return components;
     * }
     * int dfs(int u, List<Integer>[] graph, boolean[] visited) {
     * if (visited[u]) return 0;
     * visited[u] = true;
     * for (int v : graph[u]) dfs(v, graph, visited);
     * return 1;
     * }
     * }
     * Complexity:
     * <p>
     * Time: O(n+m), where m is the number of connections, n is the number of nodes.
     * Space: O(n+m),
     * ✔️ Solution 3: BFS ~ 3ms
     * <p>
     * class Solution {
     * public int countComponents(int n, int[][] edges) {
     * List<Integer>[] graph = new List[n];
     * for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
     * for (int[] e : edges) {
     * graph[e[0]].add(e[1]);
     * graph[e[1]].add(e[0]);
     * }
     * int components = 0;
     * boolean[] visited = new boolean[n];
     * for (int v = 0; v < n; v++) components += bfs(v, graph, visited);
     * return components;
     * }
     * int bfs(int src, List<Integer>[] graph, boolean[] visited) {
     * if (visited[src]) return 0;
     * visited[src] = true;
     * Queue<Integer> q = new LinkedList<>();
     * q.offer(src);
     * while (!q.isEmpty()) {
     * int u = q.poll();
     * for (int v : graph[u]) {
     * if (!visited[v]) {
     * visited[v] = true;
     * q.offer(v);
     * }
     * }
     * }
     * return 1;
     * }
     * }
     * Complexity:
     * <p>
     * Time: O(n+m), where m is the number of connections, n is the number of nodes.
     * Space: O(n+m)
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int components = n;
        for (int[] e : edges) {
            int p1 = findParent(parent, e[0]);
            int p2 = findParent(parent, e[1]);
            if (p1 != p2) {
                if (size[p1] < size[p2]) { // Merge small size to large size
                    size[p2] += size[p1];
                    parent[p1] = p2;
                } else {
                    size[p1] += size[p2];
                    parent[p2] = p1;
                }
                components--;
            }
        }
        return components;
    }

    private int findParent(int[] parent, int i) {
        if (i == parent[i]) return i;
        parent[i] = findParent(parent, parent[i]);
        return parent[i];// Path compression
    }
}
