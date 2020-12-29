package LeetCode.LC_1_200.LC32;

import java.util.ArrayDeque;

/**
 * Solution 2: Stack.
 */
public class Solution_2 {
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        int max_length = 0;
        ArrayDeque<Integer> stack = new ArrayDeque();
        stack.push(-1);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max_length = Math.max(max_length, i - stack.peek());
                }
            }
        }
        return max_length;
    }
}
