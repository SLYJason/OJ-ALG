package LeetCode.LC_601_800.LC694;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: hash by path signature.
 */
public class Solution_1 {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    String[] directions = {"R", "D", "U", "L"};
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    StringBuilder path = new StringBuilder();
                    dfs(i, j, grid, path);
                    set.add(path.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int r, int c, int[][] grid, StringBuilder sb) {
        for(int i=0; i<dirs.length; i++) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                grid[nr][nc] = 0;
                sb.append(directions[i]);
                dfs(nr, nc, grid, sb);
            }
        }
        sb.append("B"); // backtrack.
    }
}
