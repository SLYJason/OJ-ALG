package LeetCode.LC_601_800.LC695;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution: BFS.
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, max_area = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0; // mark as visited.
                    int cur = 0;
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()) {
                        int[] point = queue.poll();
                        cur++;
                        for(int[] d : directions) {
                            int nx = point[0] + d[0];
                            int ny = point[1] + d[1];
                            if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                                grid[nx][ny] = 0; // mark as visited.
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    max_area = Math.max(max_area, cur);
                }
            }
        }
        return max_area;
    }
}
