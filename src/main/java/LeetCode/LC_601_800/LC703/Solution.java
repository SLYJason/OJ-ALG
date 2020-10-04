package LeetCode.LC_601_800.LC703;

import java.util.PriorityQueue;

/**
 * Solution: using PriorityQueue, min-heap.
 */
public class Solution {
    class KthLargest {
        int k;
        int[] nums;
        PriorityQueue<Integer> pq;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.nums = nums;
            this.pq = new PriorityQueue<Integer>(k);
            for(int n : nums) add(n);
        }

        public int add(int val) {
            pq.offer(val);
            if(pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }
}
