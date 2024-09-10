package com.example.leetcode.problemtype.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        int res = obj.findKthLargest(nums,2);
        System.out.println(res);
    }
    public int findKthLargestUsingSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public int findKthLargestUsingHeap(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            q.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            q.poll();
        }
        int m = q.poll();
        return m;

    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random rand = new Random();
        while (true) {
           // int pivot_index = left + rand.nextInt(right - left + 1);
            int new_pivot_index = partition2(nums, left, right);
            if (new_pivot_index == nums.length - k) {
                return nums[new_pivot_index];
            } else if (new_pivot_index > nums.length - k) {
                right = new_pivot_index - 1;
            } else {
                left = new_pivot_index + 1;
            }
        }
    }

    private int partition2(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int pivotEle = a[low];
        while (i < j) {
            while (i <= high && a[i] <= pivotEle) {
                i++;
            }
            while (j >= low && a[j] > pivotEle) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, j, low);
        return j;

    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int stored_index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, stored_index);
                stored_index++;
            }
        }
        swap(nums, right, stored_index);
        return stored_index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
