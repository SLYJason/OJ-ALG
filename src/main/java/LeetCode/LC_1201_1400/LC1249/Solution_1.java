package LeetCode.LC_1201_1400.LC1249;

import java.util.ArrayDeque;

/**
 * Solution 1: stack.
 */
public class Solution_1 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        ArrayDeque<Integer> stack = new ArrayDeque();
        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if(stack.isEmpty()) {
                    sb.deleteCharAt(i);
                    i--;
                } else {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}
