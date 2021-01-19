package LeetCode.LC_601_800.LC787;

import java.util.Map;
import java.util.HashMap;

public class Solution_1 {
    int min_cost = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight : flights) {
            if(!graph.containsKey(flight[0])) graph.put(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }
        dfs(src, dst, 0, K + 1, new boolean[n], graph);
        return min_cost == Integer.MAX_VALUE ? -1 : min_cost;
    }

    private void dfs(int cur, int dst, int cost, int K, boolean[] visited, Map<Integer, Map<Integer, Integer>> graph) {
        if(cur == dst) {
            min_cost = cost; // Important: no need to call min(min_cost, cost).
            return;
        }
        if(K == 0) return; // no more available stops left, so stop here.
        if(graph.containsKey(cur)) {
            for(Map.Entry<Integer, Integer> neighbor : graph.get(cur).entrySet()) {
                if(visited[cur]) continue; // skip visited node since it may has cycle.
                if(cost + neighbor.getValue() > min_cost) continue; // pruning: if current cost already bigger than we have found, no need to go further.
                visited[cur] = true;
                dfs(neighbor.getKey(), dst, cost + neighbor.getValue(), K - 1, visited, graph);
                visited[cur] = false;
            }
        }
    }
}
