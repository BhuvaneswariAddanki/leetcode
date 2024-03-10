package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * For example, the below binary watch reads "4:51".
 * <p>
 * Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
 * <p>
 * The hour must not contain a leading zero.
 * <p>
 * For example, "01:00" is not valid. It should be "1:00".
 * <p>
 * The minute must consist of two digits and may contain a leading zero.
 * <p>
 * For example, "10:2" is not valid. It should be "10:02".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: turnedOn = 1
 * Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <p>
 * Example 2:
 * <p>
 * Input: turnedOn = 9
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= turnedOn <= 10
 * <p>
 * Leetcode link : https://leetcode.com/problems/binary-watch/description/
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        int[] displayedDigits = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        backTrack(displayedDigits, num, 0, 0, 0, result);
        return result;
    }

    private void backTrack(int[] displayedDigits, int num, int position, int hours, int minutes, List<String> result) {
        //when num(limit) reaches to the zero, store hours and minutes into result list
        if (num == 0) {
            //during recursion we might get e.g 4 + 8 = 12 hours which we must skip because max hour value could be 11
            if (hours <= 11 && minutes <= 59) {
                StringBuilder builder = new StringBuilder();
                builder.append(hours).append(":").append(minutes <= 9 ? "0" + minutes : minutes);
                result.add(builder.toString());
            }
            return;
        }

        //standard backtracking solution add new value do recursion and then remove it
        for (int i = position; i < displayedDigits.length; i++) {
            if (isHour(i)) hours += displayedDigits[i];
            else minutes += displayedDigits[i];

            backTrack(displayedDigits, num - 1, i + 1, hours, minutes, result);

            if (isHour(i)) hours -= displayedDigits[i];
            else minutes -= displayedDigits[i];
        }
    }

    //Simple check by range: hours or minutes
    public boolean isHour(int position) {
        return position >= 0 && position <= 3;
    }
}
