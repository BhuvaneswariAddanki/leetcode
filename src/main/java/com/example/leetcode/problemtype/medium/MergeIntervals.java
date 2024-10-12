package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * Leetcode link : https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.merge(test);

    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] prevInterval = intervals[0];
        result.add(prevInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(interval[1], prevInterval[1]);
            } else {
                prevInterval = interval;
                result.add(prevInterval);
            }

        }
        return result.toArray(new int[result.size()][]);


    }

    public int[][] merge3(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[0]);
        }

        int[] range = new int[max - min + 1];
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            range[interval[0] - min] = Math.max(interval[1] - min, range[interval[0] - min]);
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < range.length; i++) {
            if (range[i] != 0) {
                if (i <= end) {
                    end = Math.max(range[i], end);
                } else {
                    res.add(new int[]{start + min, end + min});
                    start = i;
                    end = range[i];
                }
            }
        }
        res.add(new int[]{start + min, end + min});
        return res.toArray(new int[res.size()][]);
    }

    public int[][] mergeUsingSorting(int[][] intervals) {

        List<Interval> intervalList = constructIntervalList(intervals);
        List<Interval> sortedList = intervalList.stream()
                .sorted(Comparator.comparing(Interval::getStart)
                        .thenComparing(Interval::getEnd))
                .collect(Collectors.toList());
        int index = 0;
        while (index < sortedList.size() - 1) {
            if (sortedList.get(index).end >= sortedList.get(index + 1).start) {
                sortedList.get(index).setEnd(Math.max(sortedList.get(index + 1).end, sortedList.get(index).end));
                sortedList.remove(sortedList.get(index + 1));
            } else {
                index++;
            }
        }
        int[][] result = new int[sortedList.size()][2];
        int i = 0;
        for (Interval interval : sortedList) {
            result[i][0] = interval.start;
            result[i][1] = interval.end;
            i++;
        }
        return result;
    }

    private List<Interval> constructIntervalList(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        return intervalList;
    }

    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
