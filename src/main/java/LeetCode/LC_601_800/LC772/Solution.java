package LeetCode.LC_601_800.LC772;

import java.util.ArrayDeque;

public class Solution {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        int num = 0;
        char sign = '+';
        s += "+";
        ArrayDeque<Integer> stack = new ArrayDeque();
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
            if(ch == '(') {
                int offset = findClosing(s.substring(i));
                num = calculate(s.substring(i+1, i+offset));
                i += offset;
                continue; // find a parentheses sum.
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

    // find the closing ')', here only need to return the offset from '('.
    private int findClosing(String s) {
        int level = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') level++;
            if(s.charAt(i) == ')') level--;
            if(level == 0) return i;
        }
        return -1;
    }
}
