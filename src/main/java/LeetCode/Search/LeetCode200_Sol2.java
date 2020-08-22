package LeetCode.Search;

/**
 * Solution 2: DFS.
 */
public class LeetCode200_Sol2 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(grid[row][col] == '1') {
                    dfs(grid, rows, cols, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int rows, int cols, int row, int col) {
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') return;
        grid[row][col] = '0';
        dfs(grid, rows, cols, row+1, col);
        dfs(grid, rows, cols, row-1, col);
        dfs(grid, rows, cols, row, col+1);
        dfs(grid, rows, cols, row, col-1);
    }
}
