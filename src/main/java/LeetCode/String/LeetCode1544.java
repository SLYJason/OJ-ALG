package LeetCode.String;

import java.util.Stack;

public class LeetCode1544 {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
