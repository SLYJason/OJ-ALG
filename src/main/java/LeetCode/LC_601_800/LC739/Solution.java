package LeetCode.LC_601_800.LC739;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Solution: monotonic queue.
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> deque = new ArrayDeque();
        for(int i=0; i<T.length; i++) {
            while(!deque.isEmpty() && T[deque.getLast()] < T[i]) {
                res[deque.peekLast()] = i - deque.pollLast();
            }
            deque.offer(i);
        }
        return res;
    }
}
