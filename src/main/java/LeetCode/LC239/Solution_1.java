package LeetCode.LC239;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Solution 1: brute force, using PriorityQueue causing TLE.
 */
public class Solution_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Arrays.fill(res, Integer.MIN_VALUE);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0; i<k; i++) pq.offer(nums[i]); // Initialization.
        res[0] = pq.peek();
        for(int i=1; i<nums.length-k+1; i++) {
            pq.remove(nums[i-1]);
            pq.offer(nums[i+k-1]);
            res[i] = Math.max(res[i], pq.peek());
        }
        return res;
    }
}
