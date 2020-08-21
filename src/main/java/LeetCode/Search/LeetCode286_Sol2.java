package LeetCode.Search;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 2: BFS, search from all gates .
 */
public class LeetCode286_Sol2 {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0) return;
        int rows = rooms.length;
        int cols = rooms[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList();
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(rooms[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }
        int distance = 0;
        while(!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] room = queue.poll();
                for(int[] direction : directions) {
                    int x = room[0] + direction[0];
                    int y = room[1] + direction[1];
                    if(x < 0 || x >= rows || y < 0 || y >= cols || rooms[x][y] != Integer.MAX_VALUE) continue;
                    rooms[x][y] = distance;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
