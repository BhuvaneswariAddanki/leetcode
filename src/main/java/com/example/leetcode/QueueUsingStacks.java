package com.example.leetcode;

import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> stack1 = new Stack<>();

    public QueueUsingStacks() {

    }

    public void push(int x) {
        if (stack1.isEmpty())
            stack1.push(x);
        else {
            Stack<Integer> stack2 = new Stack<>();
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.empty();
    }
}
