package LeetCode.LC_1001_1200.LC1091;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Solution 3: A* search.
 */
public class Solution_3 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if(grid[0][0] != 0 || grid[N-1][N-1] != 0) return -1; // base case.
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[][] dist = new int[N][N];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 1;
        // A* search algorithm.
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0, N - 1));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.r == N - 1 && cur.c == N - 1) return cur.g + 1;
            for(int[] dir : dirs) {
                int nr = cur.r + dir[0];
                int nc = cur.c + dir[1];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && grid[nr][nc] == 0) {
                    int next_g = cur.g + 1;
                    if(next_g < dist[nr][nc]) {
                        dist[nr][nc] = next_g;
                        int h = Math.max(N - 1 - nr, N - 1 - nc);
                        pq.offer(new Node(nr, nc, next_g, h));
                    }
                }
            }
        }
        return -1;
    }

    class Node implements Comparable<Node> {
        public int r;
        public int c;
        public int g;
        public int f;

        public Node(int r, int c, int g, int h) {
            this.r = r;
            this.c = c;
            this.g = g;
            this.f = g + h; // overall cost.
        }

        @Override
        public int compareTo(Node node) {
            return this.f - node.f;
        }
    }
}
