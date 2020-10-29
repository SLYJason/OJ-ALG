package LeetCode.LC_201_400.LC394;

import java.util.ArrayDeque;

public class Solution {
    public String decodeString(String s) {
        ArrayDeque<Character> stack = new ArrayDeque();
        for(char ch : s.toCharArray()) {
            if(ch == ']') {
                // process encoded_string.
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '[') sb.insert(0, stack.pop());
                stack.pop(); // pop up '['.

                // process k.
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) num.insert(0, stack.pop());
                int k = Integer.valueOf(num.toString());

                // mutiple encoded_string k times, and then push back to the stack.
                while(k > 0) {
                    for(char c : sb.toString().toCharArray()) stack.push(c);
                    k--;
                }
            } else {
                stack.push(ch);
            }
        }

        // build the final results.
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
