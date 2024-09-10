package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums) {
            counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(counterMap, new ArrayList<>(), result, nums.length);
        return result;
    }

    private void dfs(Map<Integer, Integer> counterMap, List<Integer> curList, List<List<Integer>> result, int length) {
        if (curList.size() == length) {
            result.add(new ArrayList<>(curList));
        } else {
            for (Map.Entry<Integer, Integer> counterEntry : counterMap.entrySet()) {
                int ele = counterEntry.getKey();
                if (counterEntry.getValue() > 0) {
                    curList.add(ele);
                    counterMap.put(ele, counterEntry.getValue() - 1);
                    dfs(counterMap, curList, result, length);
                    counterMap.put(ele, counterEntry.getValue() + 1);
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }

    public List<List<Integer>> permuteUnique2(int[] A) {
        List<List<Integer>> result = new ArrayList<>();

        directedPermutations(0, A, result);
        return result;
    }


    private static void directedPermutations(int start, int[] A, List<List<Integer>> result) {
        if (start == A.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : A) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int i = start; i < A.length; i++) {
            // Skip duplicates
            if (i > start && skip(start, i, A)) continue;

            // Swap elements
            swap(A, start, i);

            // Recurse to generate permutations
            directedPermutations(start + 1, A, result);

            // Backtrack (swap back)
            swap(A, start, i);
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static boolean skip(int start, int end, int[] nums) {
        for (int i = start; i < end; i++)
            if (nums[i] == nums[end])
                return true;
        return false;
    }

    public List<List<Integer>> permuteUnique3USingSort(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>(); // ans list
        Arrays.sort(nums); // sort the array

        // create a boolean array which track the certain indexed integer is present in out temp list or not
        helper(ans, new ArrayList<>(), nums, new boolean[nums.length]); // helper method

        return ans; // return output
    }

    private void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] vis) {

		/*
			when size of the temp list and size of the inout array are same then add this temp list into the final ans list.
			this is one of our permutation for given integer array
		*/
        if (nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        /*
			Traverse for whole array one by one.
		*/
        for (int i = 0; i < nums.length; i++) {

            if (vis[i]) continue; // if current element is already present in the temp, skip the element
            if (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])
                continue; // if prev element and current element is equal, skip the element

            vis[i] = true;
            temp.add(nums[i]);

            helper(ans, temp, nums, vis); // recursive call

            // backtracking
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }

}
