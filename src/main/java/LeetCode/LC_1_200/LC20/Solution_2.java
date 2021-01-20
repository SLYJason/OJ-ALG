package LeetCode.LC_1_200.LC20;

import java.util.ArrayDeque;

/**
 * Solution 2: concise stack.
 */
public class Solution_2 {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque();
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(')');
            } else if(ch == '{') {
                stack.push('}');
            } else if(ch == '[') {
                stack.push(']');
            } else if(stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
