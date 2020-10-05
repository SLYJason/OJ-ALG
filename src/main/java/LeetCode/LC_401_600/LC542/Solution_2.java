package LeetCode.LC_401_600.LC542;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 2: one-time BFS.
 */
public class Solution_2 {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        int distance = 0;
        // BFS.
        while(!queue.isEmpty()) {
            distance++;
            for(int i=queue.size(); i>0; i--) {
                int[] cur = queue.poll();
                for(int[] d : directions) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if(nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length) {
                        if(matrix[nx][ny] == -1) {
                            matrix[nx][ny] = distance;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return matrix;
    }
}
