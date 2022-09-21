package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * <p>
 * Implement the MyStack class:
 * <p>
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * <p>
 * Notes:
 * <p>
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * <p>
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class StackUsingQueues {
    private Queue<Integer> queue = new LinkedList<>();

    public StackUsingQueues() {

    }
    public void push(int x) {
        queue.add(x);
        int l = queue.size();
        while (l > 1) {
            queue.add(queue.remove());
            l--;
        }

    }
    public int pop() {
        return queue.remove();
    }

    public int top() {
        if (queue.size() > 0)
            return queue.peek();
        else
            return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
