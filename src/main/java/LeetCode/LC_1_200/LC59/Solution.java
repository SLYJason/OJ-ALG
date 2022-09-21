package LeetCode.LC_1_200.LC59;

/**
 * Solution: move patterns.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = 0, d = 0;
        for (int i = 0; i < n * n; i++) {
            res[r][c] = i + 1;
            int nr = r + dirs[d][0];
            int nc = c + dirs[d][1];
            if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || res[nr][nc] != 0) {
                d = (d + 1) % 4;
                r = r + dirs[d][0];
                c = c + dirs[d][1];
            } else {
                r = nr;
                c = nc;
            }
        }
        return res;
    }
}
