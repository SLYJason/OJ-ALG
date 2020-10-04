package LeetCode.LC_201_400.LC224;

import java.util.ArrayDeque;

class Solution {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        int res = 0;
        int sign = 1;
        ArrayDeque<Integer> stack = new ArrayDeque();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int num = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                res += sign * num;
            } else if(ch == '+') {
                sign = 1;
            } else if(ch == '-') {
                sign = -1;
            } else if(ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if(ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
