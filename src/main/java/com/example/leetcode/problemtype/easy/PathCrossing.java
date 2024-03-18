package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 * <p>
 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
 * <p>
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 * <p>
 * Example 2:
 * <p>
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 * <p>
 * Constraints:
 * <p>
 * 1 <= path.length <= 104
 * path[i] is either 'N', 'S', 'E', or 'W'.
 * <p>
 * Leetcode link : https://leetcode.com/problems/path-crossing/description/
 */
public class PathCrossing {

    public boolean isPathCrossing(String path) {
        List<Point> visitedPoints = new ArrayList<>();
        Point current = new Point(0, 0);
        visitedPoints.add(new Point(0, 0));
        Map<Character, Point> map = new HashMap<>();
        map.put('E', new Point(1, 0));
        map.put('W', new Point(-1, 0));
        map.put('N', new Point(0, 1));
        map.put('S', new Point(0, -1));

        for (int i = 0; i < path.length(); i++) {
            Point p = map.get(path.charAt(i));
            current.x += p.x;
            current.y += p.y;
            if (visitedPoints.contains(current)) {
                return true;
            }
            visitedPoints.add(new Point(current.x, current.y));
        }
        return false;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
