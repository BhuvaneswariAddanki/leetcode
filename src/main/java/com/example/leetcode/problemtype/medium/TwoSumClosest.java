package com.example.leetcode.problemtype.medium;

import java.util.Arrays;

public class TwoSumClosest {
    public static void main(String[] args) {

    }

    public int closestSum(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int closest = Integer.MAX_VALUE;
        while (low < high) {
            int currentSum = nums[low] + nums[high];
            if (currentSum == target) {
                return target;
            } else if (currentSum > target) {
                high--;
            } else {
                low--;
            }
            if (Math.abs(target - currentSum) < Math.abs(closest - target)) {
                closest = currentSum;
            }
        }
        return closest;
    }

    public int[] closestSumWithValues(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (low < high) {
            int currentSum = nums[low] + nums[high];
            if (currentSum == target) {
                return new int[]{nums[low], nums[high]};
            } else if (currentSum > target) {
                high--;
            } else {
                low--;
            }
            if (minDiff > Math.abs(target - currentSum)) {
                minDiff = Math.abs(target - currentSum);
                result[0] = nums[low];
                result[1] = nums[high];
            }
        }
        return result;
    }

    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        int minDiff = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return minDiff;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return 0;
            }
            minDiff = Math.min(minDiff, Math.abs(target - sum));
            int mid = start + (end - start) / 2;
            if (sum < target) {
                if (nums[mid] + nums[end] <= target) {
                    start = mid;
                } else {
                    start++;
                }
            } else {
                if (nums[start] + nums[mid] >= target) {
                    end = mid;
                } else {
                    end--;
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(target - nums[start] - nums[end]));
        return minDiff;
    }
}
