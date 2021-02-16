package LeetCode.LC_1201_1400.LC1337;

import java.util.PriorityQueue;

/**
 * Solution 1: linear search + max heap.
 */
public class Solution_1 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            if(n1[0] == n2[0]) return n2[1] - n1[1];
            return n2[0] - n1[0];
        });
        for(int i=0; i<m; i++) {
            int ones = 0;
            for(int j=0; j<n && mat[i][j] == 1; j++) {
                ones++;
            }
            pq.offer(new int[]{ones, i});
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        while(k > 0) {
            res[--k] = pq.poll()[1];
        }
        return res;
    }
}
