package LeetCode.LC1209;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution 2: using Stack.
 */
public class Solution_2 {
    public String removeDuplicates(String s, int k) {
        if(s.length() < 2) return s;
        Deque<Integer> stack = new ArrayDeque();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++) {
            if(i > 0 && sb.charAt(i-1) == sb.charAt(i)) {
                int count = stack.pop();
                count++;
                if(count == k) {
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                } else {
                    stack.push(count);
                }
            } else {
                stack.push(1);
            }
        }
        return sb.toString();
    }
}
