package LeetCode.LC_1_200.LC54;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution: move patterns.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = 0, d = 0;
        while (res.size() < rows * cols) {
            res.add(matrix[r][c]);
            visited[r][c] = true;
            int nr = r + dirs[d][0];
            int nc = c + dirs[d][1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) {
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
