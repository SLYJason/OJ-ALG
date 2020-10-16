package LeetCode.LC_401_600.LC547;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 2: BFS.
 */
public class Solution_2 {
    public int findCircleNum(int[][] M) {
        if(M.length == 0) return 1;
        int N = M.length;
        boolean[] visited = new boolean[N];
        // BFS.
        int res = 0;
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                res++;
                bfs(i, N, M, visited);
            }
        }
        return res;
    }

    private void bfs(int i, int N, int[][] M, boolean[] visited) {
        Queue<Integer> queue = new LinkedList();
        queue.add(i);
        while(!queue.isEmpty()) {
            int person = queue.poll();
            visited[person] = true;
            for(int friend = 0; friend < N; friend++) {
                if(M[person][friend] == 1 && !visited[friend]) queue.add(friend);
            }
        }
    }
}
