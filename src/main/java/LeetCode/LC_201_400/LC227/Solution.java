package LeetCode.LC_201_400.LC227;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        int num = 0;
        char sign = '+';
        s += "+";
        Stack<Integer> stack = new Stack();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') continue; // skip blank.
            if(Character.isDigit(ch)) {
                num = ch - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                continue; // find a number.
            }
            // ch is a sign.
            if(sign == '+') {
                stack.push(num);
            } else if(sign == '-') {
                stack.push(-num);
            } else if(sign == '*') {
                stack.push(stack.pop()*num);
            } else if(sign == '/') {
                stack.push(stack.pop()/num);
            }
            sign = ch;
        }

        int sum = 0;
        while(!stack.isEmpty()) sum += stack.pop();
        return sum;
    }
}
