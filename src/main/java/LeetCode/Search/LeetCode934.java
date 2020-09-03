package LeetCode.Search;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution: DFS + BFS.
 */
public class LeetCode934 {
    public int shortestBridge(int[][] A) {
        int distance = -1;
        boolean painted = false;
        Queue<int[]> queue = new LinkedList();
        int[][] dirs = {{1 ,0}, {0, 1}, {-1, 0}, {0, -1}};
        // Step 1: DFS painting 1st island to 2 and add them into the queue.
        for(int i=0; i<A.length && !painted; i++) {
            for(int j=0; j<A[0].length && !painted; j++) {
                if(A[i][j] == 1) {
                    fillIsland(A, i, j, queue);
                    painted = true;
                }
            }
        }
        // Step 2: expanding fill cell with 2.
        while(!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] point = queue.poll();
                for(int[] dir : dirs) {
                    int nextX = point[0] + dir[0];
                    int nextY = point[1] + dir[1];
                    if(nextX < 0 || nextX >= A.length || nextY < 0 || nextY >= A[0].length || A[nextX][nextY] == 2) continue;
                    if(A[nextX][nextY] == 1) return distance;
                    A[nextX][nextY] = 2;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return -1;
    }

    private void fillIsland(int[][] A, int i, int j, Queue<int[]> queue) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0) return;
        if(A[i][j] == 1) {
            queue.offer(new int[]{i, j});
            A[i][j] = 2;
            fillIsland(A, i-1, j, queue);
            fillIsland(A, i+1, j, queue);
            fillIsland(A, i, j-1, queue);
            fillIsland(A, i, j+1, queue);
        }
    }
}
