package com.example.leetcode.problemtype.easy;

import com.example.leetcode.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 * <p>
 * You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
 * <p>
 * Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
 * <p>
 * Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: moves = "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
 * <p>
 * Example 2:
 * <p>
 * Input: moves = "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= moves.length <= 2 * 104
 * moves only contains the characters 'U', 'D', 'L' and 'R'.
 * <p>
 * Leetcode link : https://leetcode.com/problems/robot-return-to-origin/description/
 */
public class RobotReturnToOrigin {
    public static void main(String[] args) {
        RobotReturnToOrigin robotReturnToOrigin = new RobotReturnToOrigin();
        boolean result = robotReturnToOrigin.judgeCircle("UD");
        System.out.println(result);
    }

    public boolean judgeCircle(String moves) {

        Point p = new Point(0, 0);

        for (char c : moves.toCharArray()) {

            if (c == 'L') {
                p.setX(p.getX() - 1);
            } else if (c == 'R') {
                p.setX(p.getX() + 1);
            } else if (c == 'U') {
                p.setY(p.getY() + 1);
            } else {
                p.setY(p.getY() - 1);
            }

        }
        return p.getX() == 0 && p.getY() == 0;
    }

    public boolean judgeCircleWithMap(String moves) {
        Map<Character, Integer> noOfMovesInDirectionMap = new HashMap<>();
        for (Character move : moves.toCharArray()) {
            noOfMovesInDirectionMap.put(move, noOfMovesInDirectionMap.getOrDefault(move, 0) + 1);
        }
        return noOfMovesInDirectionMap.getOrDefault('L', 0).equals(noOfMovesInDirectionMap.getOrDefault('R', 0))
                && noOfMovesInDirectionMap.getOrDefault('U', 0).equals(noOfMovesInDirectionMap.getOrDefault('D', 0));
    }

    public boolean judgeCircleWithVariables(String moves) {
        int counter1 = 0;
        int counter2 = 0;
        for (Character move : moves.toCharArray()) {
            if (move == 'L') {
                counter1++;
            } else if (move == 'R') {
                counter1--;
            } else if (move == 'U') {
                counter2++;
            } else if (move == 'D') {
                counter2--;
            }
        }
        return counter1 == 0 && counter2 == 0;
    }
}
