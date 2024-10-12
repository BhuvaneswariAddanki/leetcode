package com.example.leetcode.problemtype.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
    public static void main(String[] args) {
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] res = courseScheduleII.findOrder(4, pre);

    }


    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int[] topo = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[index++] = node;
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        if (index == n) return topo;
        return new int[]{};
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        for (int[] pre : prerequisites) {
            if (map.containsKey(pre[1])) {
                map.get(pre[1]).add(pre[0]);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(pre[0]);
                map.put(pre[1], list);
            }
        }
        boolean[] visited = new boolean[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                topologicalSort(i, map, visited, stack);
            }
        }

        int[] result = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private void topologicalSort(Integer vertex, Map<Integer, LinkedList<Integer>> map, boolean[] visited, Deque<Integer> stack) {
        visited[vertex] = true;
        for (Integer neighbour : map.getOrDefault(vertex, new LinkedList<>())) {
            if (!visited[neighbour]) {
                topologicalSort(neighbour, map, visited, stack);
            }
        }
        stack.push(vertex);
    }


}
