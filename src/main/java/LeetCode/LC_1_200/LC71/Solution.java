package LeetCode.LC_1_200.LC71;

import java.util.ArrayDeque;

/**
 * Solution: deque.
 */
public class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        for(String s : path.split("/")) {
            if(s.equals("") || s.equals(".")) continue;
            if(Character.isAlphabetic(s.charAt(0))) {
                deque.offer(s);
            } else {
                if(s.equals("..") && !deque.isEmpty()) {
                    deque.pollLast();
                } else if(s.length() >= 3) {
                    deque.offer(s);
                }
            }
        }
        if(deque.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append("/").append(deque.poll());
        }
        return sb.toString();
    }
}
