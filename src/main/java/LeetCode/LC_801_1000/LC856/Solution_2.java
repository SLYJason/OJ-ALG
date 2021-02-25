package LeetCode.LC_801_1000.LC856;

import java.util.ArrayDeque;

/**
 * Solution 2: stack.
 */
public class Solution_2 {
    public int scoreOfParentheses(String S) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cur = 0; // current score in current level.
        for(char c : S.toCharArray()) {
            if(c == '(') {
                stack.push(cur);
                cur = 0;
            } else { // if meet ')', cur will be doubled or at least 1.
                int pre = stack.pop();
                cur = pre + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
}
