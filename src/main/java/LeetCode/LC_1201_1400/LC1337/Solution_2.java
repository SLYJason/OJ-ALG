package LeetCode.LC_1201_1400.LC1337;

import java.util.PriorityQueue;

/**
 * Solution 2: binary search + max heap.
 */
public class Solution_2 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            if(n1[0] == n2[0]) return n1[1] - n2[1];
            return n1[0] - n2[0];
        });
        for(int i=0; i<m; i++) {
            int ones = binarySearch(mat[i]);
            pq.offer(new int[]{ones, i});
        }
        int[] res = new int[k];
        while(k > 0) {
            res[res.length - k] = pq.poll()[1];
            k--;
        }
        return res;
    }

    private int binarySearch(int[] row) {
        int l = 0, r = row.length-1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(row[m] == 0) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
