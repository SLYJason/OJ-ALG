package LeetCode.LC_801_1000.LC973;

import java.util.PriorityQueue;

/**
 * Solution 2: max-heap of size K solution, using PriorityQueue.
 */
public class Solution_2 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) ->
                p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
