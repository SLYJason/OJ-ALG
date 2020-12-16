package LeetCode.LC_201_400.LC385;

import java.util.ArrayDeque;

/**
 * Solution: stack.
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        ArrayDeque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int start = 1; // start means the number start position.
        for(int i=1; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '[') {
                NestedInteger n = new NestedInteger();
                stack.peek().add(n);
                stack.push(n);
                start = i+1;
            } else if(ch == ',' || ch == ']') {
                if(i > start) {
                    int num = Integer.parseInt(s.substring(start, i));
                    stack.peek().add(new NestedInteger(num));
                }
                start = i+1;
                if(ch == ']') stack.pop();
            }
        }
        return res;
    }
}
