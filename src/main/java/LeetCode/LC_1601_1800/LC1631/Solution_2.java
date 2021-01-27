package LeetCode.LC_1601_1800.LC1631;

/**
 * Solution 2: binary search + DFS.
 */
public class Solution_2 {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int left = 0, right = 1000000 - 1, min = 1000000 - 1; // the min effort is: 0, the max effort is 1000000 - 1.
        while(left <= right) {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[rows][cols];
            visited[0][0] = true;
            if(dfs(0, 0, heights, visited, mid)) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    private boolean dfs(int r, int c, int[][] heights, boolean[][] visited, int k) {
        if(r == heights.length - 1 && c == heights[0].length - 1) return true;
        for(int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !visited[nr][nc]) {
                if(Math.abs(heights[r][c] - heights[nr][nc]) <= k) { // go to next cell using a constraint: the effort should be less or equal to k.
                    visited[nr][nc] = true;
                    if(dfs(nr, nc, heights, visited, k)) return true;
                }
            }
        }
        return false;
    }
}

