package LeetCode.LC_1_200.LC155;

import java.util.ArrayDeque;

/**
 * Solution 1: Two stacks.
 * A defect of this solution is if same minimum element keeping inserted into the stack, there will be lot of duplicates of min element.
 *
 * Time Complexity: O(1).
 * Space Complexity: O(n)
 */
public class Solution_1 {
    class MinStack {
        ArrayDeque<Integer> stack;
        ArrayDeque<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<Integer>();
            minStack = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            if(minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            int x = stack.pop();
            if(x == minStack.peek()) minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
