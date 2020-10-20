package LeetCode.LC_801_1000.LC980;

/**
 * Solution: DFS + backtrack.
 */
public class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int res = 0;
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int steps = rows * cols;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == -1) --steps; // the total 0 cells need to be reached.
            }
        }
        // find starting point and go to DFS + backtrack.
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    boolean[][] visited = new boolean[rows][cols];
                    visited[i][j] = true;
                    dfs(i, j, 1, steps, grid, visited);
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y, int cur, int steps, int[][] grid, boolean[][] visited) {
        if(cur == steps && grid[x][y] == 2) {
            res++;
            return;
        }
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && (grid[nx][ny] == 0 || grid[nx][ny] == 2) && !visited[nx][ny]) {
                ++cur;
                visited[nx][ny] = true;
                dfs(nx, ny, cur, steps, grid, visited);
                visited[nx][ny] = false;
                --cur;
            }
        }
    }
}
