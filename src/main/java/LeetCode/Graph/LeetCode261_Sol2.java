package LeetCode.Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 2: Advanced BFS.
 *
 * To make a valid tree, check 2 things:
 * 1> All nodes are connected.
 * 2> n nodes only have n-1 edges.
 */
public class LeetCode261_Sol2 {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false; // n nodes must only have n-1 edges.
        List<List<Integer>> graph = new ArrayList();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet();
        Queue<Integer> queue = new LinkedList();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);
            for(int neighbour : graph.get(node)) {
                if (visited.contains(neighbour)) continue;
                queue.offer(neighbour);
            }
        }
        return visited.size() == n;
    }
}
