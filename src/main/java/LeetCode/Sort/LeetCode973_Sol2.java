package LeetCode.Sort;

import java.util.PriorityQueue;

/**
 * Solution 2: max-heap of size K solution, using PriorityQueue.
 * Time Complexity: O(NlogK).
 * Space Complexity: O(K).
 * Rules of thumb: Largest -> Min Heap, Smallest -> Max Heap.
 */
public class LeetCode973_Sol2 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) ->
                p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for(int[] point : points) {
            pq.offer(point);
            if(pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        for(int i=0; i<res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
