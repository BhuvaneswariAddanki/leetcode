package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 * <p>
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
 * <p>
 * Return the decompressed list.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,1,2,3]
 * Output: [1,3,3]
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 * leetcode link : https://leetcode.com/problems/decompress-run-length-encoded-list/description/
 */
public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            for (int j = nums[i]; j > 0; j--) {
                result.add(nums[i + 1]);
            }
        }
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (int ele : result) {
            resultArray[index++] = ele;
        }
        return resultArray;
    }

}
