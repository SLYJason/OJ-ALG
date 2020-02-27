package LeetCode;

import java.util.Stack;

public class LeetCode716 {
    class MaxStack {

        Stack<Integer> stack;
        Stack<Integer> maxStack;
        /** initialize your data structure here. */
        public MaxStack() {
            stack = new Stack();
            maxStack = new Stack();
        }

        public void push(int x) {
            int max = stack.isEmpty() ? x : x >= maxStack.peek() ? x : maxStack.peek();
            maxStack.push(max);
            stack.push(x);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = peekMax();
            Stack<Integer> buffer = new Stack();
            // fill the buffer until find the maximum element;
            while(top() != max) {
                buffer.push(pop());
            }
            pop(); // retrive and remove the maximum element;
            // refill the stack and maxStack;
            while(!buffer.isEmpty()) {
                push(buffer.pop());
            }
            return max;
        }
    }

}
