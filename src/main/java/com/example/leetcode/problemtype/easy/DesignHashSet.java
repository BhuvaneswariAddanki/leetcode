package com.example.leetcode.problemtype.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * Implement MyHashSet class:
 * <p>
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= key <= 106
 * At most 104 calls will be made to add, remove, and contains.
 * <p>
 * Leetcode link : https://leetcode.com/problems/design-hashset/description/
 */
public class DesignHashSet {

    private static final int NUM_BUCKETS = 1000;
    private List<List<Integer>> buckets;

    public DesignHashSet() {
        buckets = new ArrayList<>(NUM_BUCKETS);
        for (int i = 0; i < NUM_BUCKETS; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int hash = key % NUM_BUCKETS;
        List<Integer> bucket = buckets.get(hash);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int hash = key % NUM_BUCKETS;
        List<Integer> bucket = buckets.get(hash);
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int hash = key % NUM_BUCKETS;
        List<Integer> bucket = buckets.get(hash);
        return bucket.contains(key);
    }
}
