package com.example.leetcode.problemtype.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 * <p>
 * Example 2:
 * <p>
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".
 * <p>
 * Example 3:
 * <p>
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * All strings consist of lowercase and uppercase English letters and the space character.
 * <p>
 * Leetcode link :
 */
public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> sources = new HashSet<>();
        for (List<String> path : paths) {
            sources.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!sources.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
