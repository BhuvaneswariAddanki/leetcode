package com.example.leetcode.problemtype.easy;

/**
 * Given two integer arrays startTime and endTime and given an integer queryTime.
 * <p>
 * The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
 * <p>
 * Return the number of students doing their homework at time queryTime. More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * Output: 1
 * Explanation: We have 3 students where:
 * The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
 * The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
 * The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.
 * <p>
 * Example 2:
 * <p>
 * Input: startTime = [4], endTime = [4], queryTime = 4
 * Output: 1
 * Explanation: The only student was doing their homework at the queryTime.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * startTime.length == endTime.length
 * 1 <= startTime.length <= 100
 * 1 <= startTime[i] <= endTime[i] <= 1000
 * 1 <= queryTime <= 1000
 * <p>
 * Leetcode link : https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/description/
 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int busyStudentsCount = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                busyStudentsCount++;
            }
        }
        return busyStudentsCount;

    }
}
