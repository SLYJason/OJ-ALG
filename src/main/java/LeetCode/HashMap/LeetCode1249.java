package LeetCode.HashMap;

import java.util.Stack;
public class LeetCode1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<int[]> stack = new Stack();
        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == '(') {
                stack.push(new int[]{ch, i});
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
            sb.deleteCharAt(stack.pop()[1]);
        }
        return sb.toString();
    }
}
