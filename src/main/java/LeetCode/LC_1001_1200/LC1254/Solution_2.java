package LeetCode.LC_1001_1200.LC1254;

/**
 * Solution 2: flood fill.
 */
public class Solution_2 {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        // step 1: fill the edges.
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1) {
                    fill(grid, r, c);
                }
            }
        }
        // step 2: find the closed islands and fill it same time.
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    res++;
                    fill(grid, r, c);
                }
            }
        }
        return res;
    }

    private void fill(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1) return;
        grid[r][c] = 1;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            fill(grid, nr, nc);
        }
    }
}
