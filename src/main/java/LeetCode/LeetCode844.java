package LeetCode;

import java.util.Stack;

public class LeetCode844 {
    public boolean backspaceCompare(String S, String T) {
        return backSpaceString(S).equals(backSpaceString(T));
    }

    private String backSpaceString(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return String.valueOf(stack);
    }
}
