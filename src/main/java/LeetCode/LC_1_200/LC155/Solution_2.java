package LeetCode.LC_1_200.LC155;

import java.util.ArrayDeque;

/**
 * Solution 1: Improved two stacks.
 * Time Complexity: O(1).
 * Space Complexity: O(n)
 */
public class Solution_2 {
    class MinStack {
        ArrayDeque<Integer> stack;
        ArrayDeque<int[]> minStack; // int[0] means min number, int[1] counts of min number.
        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<Integer>();
            minStack = new ArrayDeque<int[]>();
        }

        public void push(int x) {
            if(minStack.isEmpty() || x < minStack.peek()[0]) {
                minStack.push(new int[]{x, 1});
            } else if(x == minStack.peek()[0]) {
                ++minStack.peek()[1];
            }
            stack.push(x);
        }

        public void pop() {

            int x = stack.pop();
            if(x == minStack.peek()[0]) --minStack.peek()[1];
            if(minStack.peek()[1] == 0) minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek()[0];
        }
    }
}
