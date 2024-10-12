package com.example.leetcode.problemtype.medium;

import java.util.Arrays;

public class MinimumNumberOfTapsToOpenToWaterAGarden {

    public int minTaps(int n, int[] ranges) {

        int[] maxSoFar = new int[n];
        int[] intervals = new int[n];
        Arrays.fill(intervals, -1);
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(i - ranges[i], 0);
            int right = i + ranges[i];
            intervals[left] = Math.max(intervals[left], right);
        }
        int max = -1;
        for (int index = 0; index < n; index++) {
            max = Math.max(intervals[index], max);
            maxSoFar[index] = max;
        }

        int longest = maxSoFar[0];
        int count = 1;
        while (longest < n) {
            if (maxSoFar[longest] <= longest) return -1;
            longest = maxSoFar[longest];
            count++;
        }
        return count;
    }
}
