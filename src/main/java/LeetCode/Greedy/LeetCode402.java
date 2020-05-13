package LeetCode.Greedy;

import java.util.Stack;

public class LeetCode402 {
    public String removeKdigits(String num, int k) {
        // corner case
        if(num.length() == k) return "0";
        Stack<Character> stack = new Stack();
        for(char ch : num.toCharArray()) {
            while(stack.size() > 0 && ch < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        // remove the remaining digits from the tail
        for(int i=0; i<k; i++) stack.pop();

        // build the final string and remove the leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(char ch : stack) {
            if(leadingZero && ch == '0') continue;
            leadingZero = false;
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
