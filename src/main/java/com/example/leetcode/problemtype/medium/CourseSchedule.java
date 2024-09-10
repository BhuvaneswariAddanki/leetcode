package com.example.leetcode.problemtype.medium;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 207. Course Schedule
 * Medium
 * Topics
 * Companies
 * Hint
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * <p>
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 * <p>
 * Leetcode link : https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        for (int[] pre : prerequisites) {
            if (map.containsKey(pre[0])) {
                map.get(pre[0]).add(pre[1]);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(pre[1]);
                map.put(pre[0], list);
            }
        }
        boolean[] visited = new boolean[numCourses];
        for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {

            if (!visited[entry.getKey()] && canFormCycle(map, entry.getKey(), visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFormCycle(Map<Integer, LinkedList<Integer>> map, Integer course, boolean[] visited) {

        if (!visited[course]) {
            visited[course] = true;
            LinkedList<Integer> preReqList = map.getOrDefault(course, new LinkedList<>());
            for (Integer preReq : preReqList) {
                if (canFormCycle(map, preReq, visited)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
