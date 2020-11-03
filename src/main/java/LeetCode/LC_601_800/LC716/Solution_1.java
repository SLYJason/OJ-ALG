package LeetCode.LC_601_800.LC716;

import java.util.ArrayDeque;

/**
 * Solution 1: using two stacks.
 */
public class Solution_1 {
    class MaxStack {
        ArrayDeque<Integer> stack;
        ArrayDeque<Integer> maxStack;
        /** initialize your data structure here. */
        public MaxStack() {
            stack = new ArrayDeque();
            maxStack = new ArrayDeque();
        }

        public void push(int x) {
            if(maxStack.isEmpty() || x >= maxStack.peek()) {
                maxStack.push(x);
            }
            stack.push(x);
        }

        public int pop() {
            int x = stack.pop();
            if(x == maxStack.peek()) maxStack.pop();
            return x;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = maxStack.pop();
            ArrayDeque<Integer> buffer = new ArrayDeque();
            while(max != stack.peek()) {
                buffer.push(stack.pop());
            }
            stack.pop(); // pop max from stack.
            while(!buffer.isEmpty()) push(buffer.pop());
            return max;
        }
    }
}
