package LeetCode.LC_201_400.LC215;

import java.util.PriorityQueue;

/**
 * Solution 1: min heap.
 */
public class Solution_1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        for(int num : nums) {
            min_heap.offer(num);
            if(min_heap.size() > k) min_heap.poll();
        }
        return min_heap.peek();
    }
}
