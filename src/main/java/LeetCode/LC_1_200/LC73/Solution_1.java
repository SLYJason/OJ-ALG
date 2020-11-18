package LeetCode.LC_1_200.LC73;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: brute force
 */
public class Solution_1 {
    public void setZeroes(int[][] matrix) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = matrix.length, cols = matrix[0].length;
        Queue<int[]> queue = new LinkedList();
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(matrix[r][c] == 0) queue.add(new int[]{r, c});
            }
        }
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];
            for(int[] dir : dirs) {
                dfs(r, c, matrix, dir);
            }
        }
    }

    private void dfs(int r, int c, int[][] matrix, int[] dir) {
        int x = r + dir[0];
        int y = c + dir[1];
        if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
            matrix[x][y] = 0;
            dfs(x, y, matrix, dir);
        }
    }
}
