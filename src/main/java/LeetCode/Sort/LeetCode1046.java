package LeetCode.Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode1046 {
    // Initial thought
    public int lastStoneWeight(int[] stones) {
        int p = stones.length-2;
        Arrays.sort(stones);
        for(;p>=0;) {
            if(stones[p] == stones[p+1]) {
                if(p == 0) stones[0] = 0;
                p -= 2;
            } else {
                stones[p] = stones[p+1] - stones[p];
                p -= 1;
            }
            Arrays.sort(stones);
        }
        return stones[0];
    }

    // Using PriorityQueue(heap)
    // Time Complexity: O(NlogN) --- offer(), poll(), remove() takes O(logN) time.
    // Space Complexity: O(N) --- create PriorityQueue takes O(N) space.
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a ,b) -> b - a);
        for(int s:stones) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}
