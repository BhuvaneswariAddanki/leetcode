package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * <p>
 * Leetcode link : https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recurPermute(0, nums, res);
        return res;
    }

    public void recurPermute(int index, int[] nums, List<List<Integer>> res) {
        // Base condition
        if (index == nums.length) {
            List<Integer> currentPermute = new ArrayList<>();
            for (int num : nums) {
                currentPermute.add(num);
            }
            res.add(currentPermute);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, res);
            swap(i, index, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permutation(input, result, new ArrayList<>(), new boolean[input.size()]);
        return result;
    }

    private void permutation(List<Integer> possibilities, List<List<Integer>> result, List<Integer> ans, boolean[] used) {
        if (ans.size() == possibilities.size()) {
            result.add(new ArrayList<>(ans));
        } else {

            for (int i = 0; i < possibilities.size(); i++) {
                if (used[i]) continue;
                Integer ele = possibilities.get(i);
                ans.add(ele);
                used[i] = true;
                permutation(possibilities, result, ans, used);
                ans.remove(ele);
                used[i] = false;
            }
        }
    }

}
