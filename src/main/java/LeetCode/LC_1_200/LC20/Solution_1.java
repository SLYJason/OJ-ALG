package LeetCode.LC_1_200.LC20;

import java.util.ArrayDeque;

/**
 * Solution 1: verbose stack.
 */
public class Solution_1 {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque();
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                char open = stack.pop();
                if(open == '(' && ch != ')' || open == '{' && ch != '}' || open == '[' && ch != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
