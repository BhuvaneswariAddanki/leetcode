package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * Leetcode link : https://leetcode.com/problems/3sum/description/
 */
public class Three3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (sum == 0) {
                        // Found a triplet with zero sum
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        // Skip duplicate elements for j
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }

                        // Skip duplicate elements for k
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }

                        // Move the pointers
                        j++;
                        k--;
                    } else if (sum < 0) {
                        // Sum is less than zero, increment j to increase the sum
                        j++;
                    } else {
                        // Sum is greater than zero, decrement k to decrease the sum
                        k--;
                    }
                }

            }
        }
        return ans;
    }


}
