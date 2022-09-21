package com.example.leetcode;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Example 1:
 * <p>
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    private StackNode stack;
    private int min_value = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        StackNode node = new StackNode();
        node.val = val;
        if (stack != null) {
            node.next = stack;
        }
        stack = node;
        if (min_value > val) {
            min_value = val;
        }

    }

    public void pop() {
        int topValue = stack.val;
        stack = stack.next;
        if (topValue == min_value) {
            StackNode current =stack;
            min_value = Integer.MAX_VALUE;
            while(current!=null){
                min_value= Math.min(min_value,current.val);
                current=current.next;
            }
        }
    }

    public int top() {
        return stack.val;
    }

    public int getMin() {
        return min_value;
    }

    public static class StackNode {
        int val;
        StackNode next;

        public StackNode(int val) {
            this.val = val;
        }

        public StackNode() {
        }
    }
}
