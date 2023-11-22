package com.example.leetcode.twopointers;

public class TrappingRainWater {
    public int traUsingDP(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int trappedArea = 0;
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            trappedArea += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trappedArea;

    }

    public int traUsing2Pointers(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int trappedArea = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                }
                trappedArea += leftMax - height[left++];
            } else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                }
                trappedArea += rightMax - height[right--];
            }
        }
        return trappedArea;
    }
}
