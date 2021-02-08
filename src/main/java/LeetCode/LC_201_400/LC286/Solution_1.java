package LeetCode.LC_201_400.LC286;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: BFS, intuitive thought, use a extract space to track visited node.
 */
public class Solution_1 {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0) return;
        int rows = rooms.length;
        int cols = rooms[0].length;
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(rooms[row][col] == Integer.MAX_VALUE) {
                    boolean[][] visited = new boolean[rows][cols];
                    visited[row][col] = true;
                    rooms[row][col] = bfs(rooms, rows, cols, row, col, visited);
                }
            }
        }
    }

    private int bfs(int[][] rooms, int rows, int cols, int row, int col, boolean[][] visited) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int distance = 0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{row, col});
        while(!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                for(int[] direction : directions) {
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];
                    if(nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || rooms[nextX][nextY] == -1 || visited[nextX][nextY]) continue;
                    visited[nextX][nextY] = true;
                    if(rooms[nextX][nextY] == 0) return distance;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return rooms[row][col];
    }
}
