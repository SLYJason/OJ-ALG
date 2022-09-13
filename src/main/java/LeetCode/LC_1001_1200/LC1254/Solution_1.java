package LeetCode.LC_1001_1200.LC1254;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, res = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j] && isClosedIslands(grid, i, j, visited)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isClosedIslands(int[][] grid, int r, int c, boolean[][] visited) {
        if (visited[r][c]) return true;
        visited[r][c] = true;
        boolean isClosed = true;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 0) {
                if (nr == 0 || nr == grid.length - 1 || nc == 0 || nc == grid[0].length - 1) {
                    isClosed = false;
                } else {
                    isClosed = isClosedIslands(grid, nr, nc, visited) && isClosed;
                }
            }
        }
        return isClosed;
    }
}
