package LeetCode.Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: recursive DFS.
 *
 * To make a valid tree, check 2 things:
 * 1> All nodes are connected.
 * 2> There has no cycles.
 */
public class LeetCode261_Sol1 {
    public boolean validTree(int n, int[][] edges) {
        // Building a graph.
        List<List<Integer>> graph = new ArrayList();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet();
        if(!isValid(0, -1, graph, visited)) return false; // cycle detection.
        return visited.size() == n; // all nodes are connected.
    }

    // Check there has any cycles in the graph.
    // parent parameter is used to avoid trivial cycle like: A -> B -> A, since it is a undirected graph.
    private boolean isValid(int node, int parent, List<List<Integer>> graph, Set<Integer> visited) {
        if(visited.contains(node)) return false;
        visited.add(node);
        for(int neighbour : graph.get(node)) {
            if(parent != neighbour) {
                boolean isValid = isValid(neighbour, node, graph, visited);
                if(!isValid) return false;
            }
        }
        return true;
    }
}
