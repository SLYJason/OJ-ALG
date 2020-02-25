package LeetCode;

import java.util.Stack;

// Using two stacks approach
// Time Complexity: O(1)
// Space Complexity: O(n)
public class LeetCode155 {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    /**
     * public MinStack() {
     *         stack = new Stack();
     *         minStack = new Stack();
     *     }
     */

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
