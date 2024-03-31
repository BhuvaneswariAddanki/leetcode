package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 * (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 * Leetcode link : https://leetcode.com/problems/subsets/description/
 */
public class Subsets {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            int initialSize = result.size();
            for (int j = 0; j < initialSize; j++) {
                List<Integer> subset1 = new ArrayList<>(result.get(j));
                subset1.add(num);
                result.add(subset1);
            }
            List<Integer> subset = new ArrayList<>();
            subset.add(num);
            result.add(subset);
        }
        result.add(new ArrayList<>());
        return result;
    }

    public List<List<Integer>> subsetsUsingRecursion(int[] nums) {

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        constructSubsets(result, subset, nums, 0);
        return result;
    }

    private void constructSubsets(List<List<Integer>> result, List<Integer> subset, int[] nums, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[i]);
            constructSubsets(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
            constructSubsets(result, subset, nums, i + 1);
        }
    }


}
