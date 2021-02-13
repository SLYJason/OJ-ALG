package LeetCode.LC_1001_1200.LC1091;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: BFS.
 */
public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if(grid[0][0] != 0 || grid[N-1][N-1] != 0) return -1; // base case.
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int dist = 0;
        while(!queue.isEmpty()) {
            dist++;
            for(int i=queue.size(); i>0; i--) {
                int[] point = queue.poll();
                int r = point[0];
                int c = point[1];
                if(r == N - 1 && c == N - 1) return dist; // reach the destination.
                for(int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr >= 0 && nr < N && nc >= 0 && nc < N && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1; // Important: mark neighbor visited immediately.
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}
