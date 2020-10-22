package LeetCode.LC_1201_1400.LC1245;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution: brute force, using the graph theory do 2 time DFS.
 */
public class Solution {
    int n1 = 0, n2 = 0;
    int max1 = 0, max2 = 0;
    public int treeDiameter(int[][] edges) {
        int n = edges.length+1;
        List<List<Integer>> graph = new ArrayList();
        for(int i=0; i<n; i++) graph.add(new ArrayList());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs1(0, -1, -1, graph);
        dfs2(n1, -1, -1, graph);
        return max2;
    }

    private void dfs1(int child, int parent, int steps, List<List<Integer>> graph) {
        ++steps;
        if(steps > max1) {
            max1 = steps;
            n1 = child;
        }
        for(int neighbor : graph.get(child)) {
            if(neighbor == parent) continue;
            dfs1(neighbor, child, steps, graph);
        }
    }

    private void dfs2(int child, int parent, int steps, List<List<Integer>> graph) {
        ++steps;
        if(steps > max2) {
            max2 = steps;
            n2 = child;
        }
        for(int neighbor : graph.get(child)) {
            if(neighbor == parent) continue;
            dfs2(neighbor, child, steps, graph);
        }
    }
}
