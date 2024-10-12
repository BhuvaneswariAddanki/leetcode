package com.example.leetcode.problemtype.medium;

/**
 * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
 * <p>
 * colors[i] == 0 means that tile i is red.
 * colors[i] == 1 means that tile i is blue.
 * An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
 * <p>
 * Return the number of alternating groups.
 * <p>
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 * <p>
 * Leetcode link : 3208: https://leetcode.com/problems/alternating-groups-ii/description/?envType=company&envId=samsara&favoriteSlug=samsara-three-months
 */
public class AlternatingGroupsII {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] extendedColors = new int[n + k - 1];
        System.arraycopy(colors, 0, extendedColors, 0, n);
        System.arraycopy(colors, 0, extendedColors, n, k - 1);
        int res = 0;
        int cnt = 1;
        for (int i = 1; i < extendedColors.length; ++i) {
            if (extendedColors[i] != extendedColors[i - 1]) ++cnt;
            else cnt = 1;
            if (cnt >= k) ++res;
        }
        return res;
    }
    public int numberOfAlternatingGroups2(int[] colors, int k) {
        int count = 0;
        int j = 0;
        int n = colors.length;
        for (int i = 1; i < n * 2; i++) {
            int pre = (i - 1) % n;
            int ind = i % n;
            if (colors[ind] == colors[pre]) {
                j = (i % n);
            }

            if (i - j + 1 == k) {
                count++;
                j = (j + 1) % colors.length;
            }
        }
        return count;
    }


}
