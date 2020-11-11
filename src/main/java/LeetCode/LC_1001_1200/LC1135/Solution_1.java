package LeetCode.LC_1001_1200.LC1135;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Solution 1: Prim's Minimum Spanning Tree.
 */
public class Solution_1 {
    public int minimumCost(int N, int[][] connections) {
        if(connections.length < N-1) return -1; // base case.
        List<List<int[]>> graph = new ArrayList();
        // Step 1: build the graph.
        for(int i=0; i<N+1; i++) graph.add(new ArrayList());
        for(int[] connection : connections) {
            graph.get(connection[0]).add(new int[]{connection[1], connection[2]});
            graph.get(connection[1]).add(new int[]{connection[0], connection[2]});
        }

        // Step 2: Prim's algorithm.
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.offer(new int[]{1, 0}); // Initialization.
        Set<Integer> visited = new HashSet();
        int min_cost = 0;
        while(!pq.isEmpty()) {
            int n = pq.peek()[0], cost = pq.peek()[1];
            pq.poll();
            if(visited.contains(n)) continue; // skip edge that connected to an existing node.
            visited.add(n);
            min_cost += cost;
            for(int[] next : graph.get(n)) {
                if(visited.contains(next[0])) continue; // skip edge that connected to an existing node.
                pq.offer(next);
            }

        }
        return min_cost;
    }
}
