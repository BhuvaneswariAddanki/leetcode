package com.example.leetcode.sep15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * <p>
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * <p>
 * https://leetcode.com/problems/keys-and-rooms/
 * <p>
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms obj = new KeysAndRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(1));
        rooms.add(Collections.emptyList());
        boolean result = obj.canVisitAllRooms(rooms);
        System.out.println(result);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int[] visited = new int[rooms.size()];
        visited[0] = 1;
        visitAllPossibleRooms(0, rooms, visited);

        return visitedAllRooms(visited);

    }

    private boolean visitedAllRooms(int[] visited) {
        for (int j : visited) {
            if (j == 0) {
                return false;
            }
        }
        return true;
    }

    private void visitAllPossibleRooms(int i, List<List<Integer>> rooms, int[] visited) {

        for (int room : rooms.get(i)) {
            if (visited[room] == 0) {
                visited[room] = 1;
                visitAllPossibleRooms(room, rooms, visited);
            }
        }
    }
}
