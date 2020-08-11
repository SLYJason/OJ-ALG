package LeetCode.Search;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution: BFS
 */
public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count_fresh = 0;
        int time_elapsed = 0;
        Queue<int[]> queue = new LinkedList();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        // define the directions
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        // if no fresh oranges available, return 0 immedaitely
        if(count_fresh == 0) return 0;
        while(!queue.isEmpty()) {
            ++time_elapsed;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] point = queue.poll();
                for(int[] dir : directions) {
                    int x = point[0] + dir[0]; // neighbor x
                    int y = point[1] + dir[1]; // neighbor y
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    // mark the fresh orange as rotten
                    grid[x][y] = 2;
                    // push the rotten orange into the queue
                    queue.offer(new int[]{x, y});
                    count_fresh--;
                }
            }
        }
        // BFS last iteration all oranges would be rotten, so need to time_elapsed-1
        return count_fresh == 0 ? time_elapsed-1 : -1;
    }
}
