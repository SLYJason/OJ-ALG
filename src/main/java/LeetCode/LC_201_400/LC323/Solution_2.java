package LeetCode.LC_201_400.LC323;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Solution_2 {
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
        // BFS.
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                res++;
                bfs(i, graph, visited);
            }
        }
        return res;
    }

    private void bfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(cur);
        while(!queue.isEmpty()) {
            int n = queue.poll();
            visited[n] = true;
            for(int neighbor : graph.get(n)) {
                if(!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }
    }
}
