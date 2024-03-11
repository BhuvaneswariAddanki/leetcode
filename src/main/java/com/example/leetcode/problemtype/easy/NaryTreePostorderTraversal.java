package com.example.leetcode.problemtype.easy;

import com.example.leetcode.tree.binarytree.NTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of an n-ary tree, return the postorder traversal of its NTreeNodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 * <p>
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 * <p>
 * <p>
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 */
public class NaryTreePostorderTraversal {

    public List<Integer> postorder(NTreeNode root) {

        Deque<NTreeNode> s1 = new ArrayDeque<>();
        Deque<NTreeNode> s2 = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        s2.push(root);
        while (!s2.isEmpty()) {
            NTreeNode temp = s2.pop();
            for (int i = 0; i < temp.children.size(); i++) {
                s2.push(temp.children.get(i));
            }
            s1.push(temp);
        }
        while (!s1.isEmpty()) {
            res.add(s1.pop().val);
        }
        return res;
    }

    public List<Integer> postorderRecursive(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            postorder(root, result);
        }
        return result;
    }

    private void postorder(NTreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.children != null) {
                for (NTreeNode node : root.children) {
                    postorder(node, list);
                }
            }
            list.add(root.val);
        }
    }

}
