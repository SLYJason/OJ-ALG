package LeetCode.Search;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 2: BFS
 */
public class LeetCode490_Sol2 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length, cols = maze[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[rows][cols];
        visited[start[0]][start[1]] = true;
        queue.offer(new int[]{start[0], start[1]});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                if(curr[0] == destination[0] && curr[1] == destination[1]) {
                    return true;
                }
                for(int[] d : directions) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    while(x >= 0 && x < rows && y >= 0 && y < cols && maze[x][y] == 0) {
                        x += d[0];
                        y += d[1];
                    }
                    if(!visited[x-d[0]][y-d[1]]) {
                        queue.offer(new int[]{x-d[0], y-d[1]});
                        visited[x-d[0]][y-d[1]] = true;
                    }
                }
            }
        }
        return false;
    }
}
