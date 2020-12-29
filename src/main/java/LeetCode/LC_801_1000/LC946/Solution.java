package LeetCode.LC_801_1000.LC946;

import java.util.ArrayDeque;

/**
 * Solution: stack.
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for(int n : pushed) {
            stack.push(n);
            while(!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
