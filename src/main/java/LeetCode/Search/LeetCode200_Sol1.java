package LeetCode.Search;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: BFS, intuitive thought.
 */
public class LeetCode200_Sol1 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[rows][cols];
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(grid[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true;
                    bfs(grid, rows, cols, row, col, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int rows, int cols, int row, int col, boolean[][] visited) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{row, col});
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            for(int[] direction : directions) {
                int x = point[0] + direction[0];
                int y = point[1] + direction[1];
                if(x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] == '0') continue;
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
