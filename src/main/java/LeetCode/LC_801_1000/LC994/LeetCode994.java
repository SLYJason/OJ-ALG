package LeetCode.LC_801_1000.LC994;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution: BFS
 */
public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int rows = grid.length, cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) freshCount++;
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        if(freshCount == 0) return 0; // no infection.
        // BFS.
        int days = -1;
        while(!queue.isEmpty()) {
            days++;
            for(int i=queue.size(); i>0; i--) {
                int[] point = queue.poll();
                for(int[] direction : directions) {
                    int nextX = point[0] + direction[0];
                    int nextY = point[1] + direction[1];
                    if(nextX < 0 || nextX == rows || nextY < 0 || nextY == cols) continue;
                    if(grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        freshCount--;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return freshCount == 0 ? days : -1;
    }
}
