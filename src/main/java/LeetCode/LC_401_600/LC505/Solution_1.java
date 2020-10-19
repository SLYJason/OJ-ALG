package LeetCode.LC_401_600.LC505;

import java.util.Arrays;

/**
 * Solution 1: DFS
 */
public class Solution_1 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // distance[i][j] means the minimum number of steps required to reach the (i, j) starting from the current position
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[] curr, int[][] distance){
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] direction : directions) {
            int x = curr[0];
            int y = curr[1];
            int steps = 0;
            while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += direction[0];
                y += direction[1];
                steps++;
            }
            x -= direction[0];
            y -= direction[1];
            steps--;
            if(distance[curr[0]][curr[1]] + steps < distance[x][y]) {
                distance[x][y] = distance[curr[0]][curr[1]] + steps;
                dfs(maze, new int[]{x, y}, distance);
            }
        }
    }
}
