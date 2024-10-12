package com.example.leetcode.problemtype.easy;

/**
 * 3206. Alternating Groups I
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * There is a circle of red and blue tiles. You are given an array of integers colors. The color of tile i is represented by colors[i]:
 * <p>
 * colors[i] == 0 means that tile i is red.
 * colors[i] == 1 means that tile i is blue.
 * Every 3 contiguous tiles in the circle with alternating colors (the middle tile has a different color from its left and right tiles) is called an alternating group.
 * <p>
 * Return the number of alternating groups.
 * <p>
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 * Leetcode link : https://leetcode.com/problems/alternating-groups-i/description/?envType=company&envId=samsara&favoriteSlug=samsara-three-months
 */
public class AlternatingGroupsI {
    public int numberOfAlternatingGroups(int[] colors) {
        int x = 0;
        int n = colors.length;
        for (int i = 0; i < colors.length; i++) {
            // Check if the color at position i is the same as the color at position i+2
            // and different from the color at position i+1
            int prevIndex = i == 0 ? colors.length - 1 : i - 1;
            int nextIndex = (i + 1) % n;
            if (colors[prevIndex] == colors[nextIndex] && colors[i] != colors[nextIndex]) {
                x++;
            }
        }

        return x;
    }
}
