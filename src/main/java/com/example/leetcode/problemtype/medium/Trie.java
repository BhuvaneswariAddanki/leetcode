package com.example.leetcode.problemtype.medium;

public class Trie {

    class Node {
        Node[] child;
        boolean isWord;

        public Node() {
            this.child = new Node[26];
        }
    }

    Node start;

    public Trie() {
        start = new Node();
    }

    public void insert(String word) {
        int n = word.length();
        Node cur = start;
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (cur.child[index] == null) {
                cur.child[index] = new Node();
            }
            cur = cur.child[index];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {

        Node cur = start;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.child[index] == null) {
                return false;
            }
            cur = cur.child[index];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {

        Node cur = start;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.child[index] == null) {
                return false;
            }
            cur = cur.child[index];
        }
        return true;
    }


}
