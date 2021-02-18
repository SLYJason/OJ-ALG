package LeetCode.LC_1001_1200.LC1091;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Solution 2: dijkstra algorithm.
 */
public class Solution_2 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if(grid[0][0] != 0 || grid[N-1][N-1] != 0) return -1; // base case.
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[][] dist = new int[N][N];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 1;
        // Dijkstra algorithm.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            if(r == N - 1 && c == N - 1) return dist[r][c];
            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && grid[nr][nc] == 0) {
                    int next_dist = dist[r][c] + 1;
                    if(next_dist < dist[nr][nc]) {
                        dist[nr][nc] = next_dist;
                        pq.offer(new int[]{nr, nc, next_dist});
                    }
                }
            }
        }
        return -1;
    }
}
