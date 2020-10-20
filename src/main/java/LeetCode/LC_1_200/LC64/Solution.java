package LeetCode.LC_1_200.LC64;

/**
 * Solution: DP.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // Initialization 0th row.
        for(int i=1; i<cols; i++) {
            grid[0][i] += grid[0][i-1];
        }
        // Initialization 0th column.
        for(int i=1; i<rows; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[rows-1][cols-1];
    }
}
