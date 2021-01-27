package LeetCode.LC_1601_1800.LC1631;

import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * Solution 1: dijkstra algorithm.
 */
public class Solution_1 {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = heights.length, cols = heights[0].length;
        int[][] efforts = new int[rows][cols];
        for(int i=0; i<rows; i++) Arrays.fill(efforts[i], Integer.MAX_VALUE);
        efforts[0][0] = 0;
        // dijkstra logic.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0}); // entry: [row, column, effort].
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int effort = cur[2];
            if(r == rows - 1 && c == cols - 1) return effort; // reach the destination.
            for(int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int new_effort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));
                    if(new_effort < efforts[nr][nc]) {
                        efforts[nr][nc] = new_effort;
                        pq.offer(new int[]{nr, nc, new_effort});
                    }
                }
            }
        }
        return -1;
    }
}
