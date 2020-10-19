package LeetCode.LC_401_600.LC505;

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Solution 2: BFS
 */
public class Solution_2 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // distance[i][j] means the minimum number of steps required to reach the (i, j) starting from the current position
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{start[0], start[1]});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] d : directions) {
                int x = curr[0];
                int y = curr[1];
                int steps = 0;
                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                    steps++;
                }
                x -= d[0];
                y -= d[1];
                steps--;
                if(distance[curr[0]][curr[1]] + steps < distance[x][y]) {
                    distance[x][y] = distance[curr[0]][curr[1]] + steps;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
