package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Easy
 * Topics
 * Companies
 * Hint
 * <p>
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,1]
 * Output: [2]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * <p>
 * <p>
 * <p>
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Leetcode link : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        FindAllNumbersDisappearedInAnArray obj = new FindAllNumbersDisappearedInAnArray();
        List<Integer> result =obj.findDisappearedNumbers(nums);
        System.out.println(result);
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            numsSet.add(i);
        }
        for (int num : nums) {
            numsSet.remove(num);
        }
        return new ArrayList<>(numsSet);

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]  > 0) {
                result.add(i + 1);
            }
        }
        return result;

    }

}
