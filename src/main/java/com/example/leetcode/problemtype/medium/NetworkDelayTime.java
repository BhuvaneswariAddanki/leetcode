package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 * <p>
 * Leetcode link : https://leetcode.com/problems/network-delay-time/description/
 */
public class NetworkDelayTime {

    public int total = 0; // to return the max value

    public class Edge  // As graph is arrayList of edges so firstly creating an edge class
    {
        int src;  // source
        int dest; // its destination or source's neighbour
        int weight; // corresponding edge weight

        Edge(int src, int dest, int weight)  // constructor to initialise the new Edge object
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<Edge>[] graph = new ArrayList[n + 1]; // Adjacency List for representation of graph {n+1} because edge starts from **1 to N**

        Set<Integer> set = new HashSet<>(); // if all nodes are visited then return result else return -1 as mentioned

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();  // Creating the Adjacency list like for Node 1 ----> [] , Node 2 -----> []
        }
        for (int[] time : times) {
            // Graph creation
            int v1 = time[0];
            int v2 = time[1];
            int wt = time[2];
            graph[v1].add(new Edge(v1, v2, wt));  // as it is directed graph obviously only one edge to be connected

        }

        // At this point our graph is ready and ready to execute this problem

        // As the source is K is the question and from K we need to visit all the nodes

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getWeightSoFar)); // Min PriorityQueue for Dijkstras

        boolean[] vis = new boolean[n + 1]; // {n+1} because 1toN nodes not 0 to N-1

        pq.add(new Pair(k, 0)); //initialising the priorityQueue

        while (!pq.isEmpty()) {
            Pair current = pq.remove();

            if (!vis[current.v])  // If the node is already  not visited then do calculation
            {
                vis[current.v] = true; //else mark it as true
                set.add(current.v); // this is for final result comparing
                total = Math.max(total, current.weightSoFar); // max until now

                for (Edge neighbour : graph[current.v]) // visiting the neighbours using the current node
                {
                    if (!vis[neighbour.dest]) {
                        pq.add(new Pair(neighbour.dest, current.weightSoFar + neighbour.weight)); // prev wt + curr wt
                    }
                }
            }

        }

        if (set.size() == n) {
            return total;
        }
        return -1;


    }

    public static class Pair // As pq is of type Pair we need to mention how it is been compared with hence we go on with comparable class
    {
        int v;
        int weightSoFar;

        Pair(int v, int weightSoFar) {
            this.v = v;
            this.weightSoFar = weightSoFar;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getWeightSoFar() {
            return weightSoFar;
        }

        public void setWeightSoFar(int weightSoFar) {
            this.weightSoFar = weightSoFar;
        }
    }

}
