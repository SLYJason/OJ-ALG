package LeetCode.Search;

/**
 * Solution 1: DFS
 */
public class LeetCode490_Sol1 {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }

    private boolean dfs(int[][] maze, int[] curr, int[] destination, boolean[][] visited) {
        if(curr[0] == destination[0] && curr[1] == destination[1]) return true; // find the destination
        if(visited[curr[0]][curr[1]]) return false;
        visited[curr[0]][curr[1]] = true;
        for(int[] direction : directions) {
            int x = curr[0];
            int y = curr[1];
            while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += direction[0];
                y += direction[1];
            }
            if(dfs(maze, new int[]{x-direction[0], y-direction[1]}, destination, visited)) return true;
        }
        return false;
    }
}
