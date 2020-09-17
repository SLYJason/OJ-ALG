package LeetCode.LC239;

import java.util.ArrayDeque;

/**
 * Solution 2: Deque.
 */
public class Solution_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        ArrayDeque<Integer> deque = new ArrayDeque(); // store the index
        for(int i=0; i<nums.length; i++) {
            while(!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if(i >= k-1) {
                res[i-k+1] = nums[deque.peek()];
            }
        }
        return res;
    }
}
