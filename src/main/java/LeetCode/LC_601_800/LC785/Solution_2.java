package LeetCode.LC_601_800.LC785;

/**
 * Solution 2: DFS.
 */
public class Solution_2 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] sets = new int[n]; // 0: not assigned, -1: assign to A, 1: assign to B.
        for(int i=0; i<n; i++) {
            if(sets[i] != 0) continue;
            sets[i] = -1;
            if(!dfs(i, graph, sets)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int u, int[][] graph, int[] sets) {
        for(int v : graph[u]) {
            if(sets[v] == 0) {
                sets[v] = -sets[u];
                if(!dfs(v, graph, sets)) return false;
            } else if(sets[v] == sets[u]) {
                return false;
            }
        }
        return true;
    }
}
