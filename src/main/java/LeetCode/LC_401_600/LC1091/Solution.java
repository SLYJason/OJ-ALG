package LeetCode.LC_401_600.LC1091;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution: BFS.
 */
public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if(grid[0][0] == 1 || grid[N-1][N-1] == 1) return -1;
        if(N == 1 && grid[0][0] == 0) return 1; // handle [[0]] special case.
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0});
        int distance = 1;
        grid[0][0] = 1; // mark [0, 0] as 1 means it has been visited.
        while(!queue.isEmpty()) {
            distance++;
            for(int i=queue.size(); i>0; i--) {
                int[] cur = queue.poll();
                for(int[] d : directions) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == 0) {
                        if(nx == N-1 && ny == N-1) return distance;
                        grid[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
