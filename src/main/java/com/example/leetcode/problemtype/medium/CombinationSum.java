package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Medium
 * Topics
 * Companies
 * <p>
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 * of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 * <p>
 * Leetcode link : https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        find(candidates, target, 0, result, new ArrayList<>(), 0);
        return result;

    }

    private void find(int[] candidates, int target, int sum, List<List<Integer>> result, List<Integer> curList, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(curList));
        } else if (sum < target && index < candidates.length) {
            int candidate = candidates[index];
            curList.add(candidate);
            find(candidates, target, sum + candidate, result, curList, index);
            curList.remove(curList.size() - 1);
            find(candidates, target, sum, result, curList, index + 1);
        }
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, path, 0);
        return res;
    }

    private void backtrack(int[] nums, int target, List<Integer> path, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, target - nums[i], path, i);
            path.remove(path.size() - 1);
        }
    }
}
