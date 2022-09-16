package LeetCode.LC_1601_1800.LC1730;

import java.util.ArrayDeque;

/**
 * Solution: BFS.
 */
public class Solution {
    public int getFood(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '*') {
                    return bfs(grid, r, c);
                }
            }
        }
        return -1;
    }

    private int bfs(char[][] grid, int start, int end) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int steps = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, end});

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                if (grid[r][c] == '#') return steps;
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == 'X' || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
}
