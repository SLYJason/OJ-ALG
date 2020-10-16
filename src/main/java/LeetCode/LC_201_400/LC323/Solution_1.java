package LeetCode.LC_201_400.LC323;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList();
        // building graph.
        for(int i=0; i<n; i++) graph.add(new ArrayList());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                res++;
                dfs(i, graph, visited);
            }
        }
        return res;
    }

    private void dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        if(visited[cur]) return;
        visited[cur] = true;
        for(int neighbor : graph.get(cur)) {
            dfs(neighbor, graph, visited);
        }
    }
}
