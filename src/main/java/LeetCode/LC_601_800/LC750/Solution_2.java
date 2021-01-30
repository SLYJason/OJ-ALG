package LeetCode.LC_601_800.LC750;

/**
 * Solution 2: fixed row scan by column.
 */
public class Solution_2 {
    public int countCornerRectangles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, res = 0;
        for(int r1=0; r1<rows-1; r1++) {
            for(int r2=r1+1; r2<rows; r2++) {
                int count = 0;
                for(int c=0; c<cols; c++) {
                    if(grid[r1][c] == 1 && grid[r2][c] == 1) count++;
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}
