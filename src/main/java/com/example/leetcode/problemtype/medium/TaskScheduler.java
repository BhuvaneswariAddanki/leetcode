package com.example.leetcode.problemtype.medium;

import com.example.leetcode.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
 * <p>
 * ​Return the minimum number of intervals required to complete all tasks.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * <p>
 * Output: 8
 * <p>
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.
 * <p>
 * Example 2:
 * <p>
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * <p>
 * Output: 6
 * <p>
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 * <p>
 * With a cooling interval of 1, you can repeat a task after just one other task.
 * <p>
 * Example 3:
 * <p>
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 * <p>
 * Output: 10
 * <p>
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 * <p>
 * There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tasks.length <= 104
 * tasks[i] is an uppercase English letter.
 * 0 <= n <= 100
 * Leetcode link : https://leetcode.com/problems/task-scheduler/description/?envType=daily-question&envId=2024-03-19
 */
public class TaskScheduler {
    public static void main(String[] args) {
        char[] taks = new char[]{'A', 'C', 'A', 'B', 'D', 'B'};
        //"A","A","A","B","B","B"
        //char[] taks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(taks, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int cnt = pq.poll() - 1;

                if (cnt != 0) {
                    q.offer(new Pair<>(cnt, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().getSecondElement() == time) {
                pq.offer(q.poll().getFirstElement());
            }
        }

        return time;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] taskFreqMp = new int[26];
        for (char c : tasks) {
            taskFreqMp[c - 'A']++;
        }
        Arrays.sort(taskFreqMp);
        int batchCnt = taskFreqMp[25];
        int vacantSlots = --batchCnt * n;
        for (int indx = 0; indx < 25; indx++) {
            vacantSlots -= Math.min(taskFreqMp[indx], batchCnt);
        }
        return vacantSlots > 0 ? tasks.length + vacantSlots : tasks.length;
    }
}