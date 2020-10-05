package LeetCode.LC_201_400.LC286;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 2: BFS, search from all gates .
 */
public class LeetCode286_Sol2 {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0) return;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = rooms.length, cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int distance = 0;
        while(!queue.isEmpty()) {
            distance++;
            for(int i=queue.size(); i>0; i--) {
                int[] cur = queue.poll();
                for(int[] d : directions) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && rooms[nx][ny] == Integer.MAX_VALUE) {
                        rooms[nx][ny] = distance;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
