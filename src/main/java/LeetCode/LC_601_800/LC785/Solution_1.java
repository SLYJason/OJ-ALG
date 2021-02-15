package LeetCode.LC_601_800.LC785;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: BFS.
 */
public class Solution_1 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] sets = new int[n]; // 0: not assigned, -1: assign to A, 1: assign to B.
        for(int i=0; i<n; i++) {
            if(sets[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            sets[i] = -1; // assign start to -1: A.
            queue.offer(i);
            while(!queue.isEmpty()) {
                int u = queue.poll();
                for(int v : graph[u]) {
                    if(sets[v] == 0) {
                        sets[v] = -sets[u]; // assign neighbor to opposite set.
                        queue.offer(v);
                    } else if(sets[v] == sets[u]) { // u, v are in same set, can not be Bipartite.
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
