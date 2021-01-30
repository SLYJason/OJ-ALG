package LeetCode.LC_601_800.LC750;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int countCornerRectangles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, count = 0;
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid[r][c] == 1) {
                    for(int i=r+1; i<rows; i++) {
                        if(grid[i][c] == 1) {
                            for(int j=c+1; j<cols; j++) {
                                if(grid[r][j] == 1) {
                                    int length = j - c;
                                    int width = i - r;
                                    if(grid[r+width][c+length] == 1) count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
