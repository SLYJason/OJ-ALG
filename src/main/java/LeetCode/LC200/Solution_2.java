package LeetCode.LC200;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: BFS.
 */
public class Solution_2 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int islands = 0;
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    grid[i][j] = '0';
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for(int[] d : directions) {
                            int x = cur[0] + d[0];
                            int y = cur[1] + d[1];
                            if(x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
