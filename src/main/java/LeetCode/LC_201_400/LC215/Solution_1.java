package LeetCode.LC_201_400.LC215;

import java.util.PriorityQueue;

/**
 * Solution 1: min-heap.
 */
public class Solution_1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
