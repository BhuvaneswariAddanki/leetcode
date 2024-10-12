package com.example.leetcode.problemtype.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 300. Longest Increasing Subsequence
 * Medium
 * Topics
 * Companies
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxCount = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxCount = Math.max(maxCount,dp[i]);
        }
        return maxCount;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxCount = Math.max(maxCount,dp[i]);
        }
        return maxCount;
    }

    /**
     * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     * @param arr
     * @return
     */
    public int lengthOfLISBinarySearch(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        List<Integer> list=new ArrayList<>();
        int n=arr.length;
        list.add(arr[0]);
        for(int i=1;i<n;i++){
            if(arr[i]>list.get(list.size()-1)){
                list.add(arr[i]);
            } else{
                //binary search
                int start=0;
                int end=list.size()-1;

                while(start<=end){
                    int mid=start+(end-start)/2;
                    if(arr[i]>list.get(mid)){
                        start=mid+1;
                    }
                    else{
                        end=mid-1;
                    }

                }

                list.set(start,arr[i]);
            }
        }

        return list.size();
    }

}
