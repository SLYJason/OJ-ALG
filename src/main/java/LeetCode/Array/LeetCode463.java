package LeetCode.Array;

public class LeetCode463 {
    // Solution 1: brute force, simple counting 4 direction
    public int islandPerimeter(int[][] grid) {
        int ans = 0, up, right, down, left;
        int rows = grid.length, cols = grid[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    if(i == 0) {
                        up = 1;
                    } else {
                        up = grid[i-1][j] == 1 ? 0 : 1;
                    }
                    if(j == 0) {
                        left = 1;
                    } else {
                        left = grid[i][j-1] == 1 ? 0 : 1;
                    }
                    if(i == rows-1) {
                        down = 1;
                    } else {
                        down = grid[i+1][j] == 1 ? 0 : 1;
                    }
                    if(j == cols-1) {
                        right = 1;
                    } else {
                        right = grid[i][j+1] == 1 ? 0 : 1;
                    }
                    ans += up + left + down + right;
                }
            }
        }
        return ans;
    }

    // Solution 2: better counting
    public int islandPerimeter2(int[][] grid) {
        int ans = 0;
        int rows = grid.length, cols = grid[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    ans += 4;
                    if(i > 0 && grid[i-1][j] == 1) ans -= 2;
                    if(j > 0 && grid[i][j-1] == 1) ans -= 2;
                }
            }
        }
        return ans;
    }
}
