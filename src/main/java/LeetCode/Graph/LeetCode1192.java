package LeetCode.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class LeetCode1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new LinkedList();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }

        int[] ranks = new int[n];
        Arrays.fill(ranks, -1);
        dfs(0, -1, 0, ranks, graph, res);
        return res;
    }

    // starting from the curr, exploring all the connected neighbors and return the minimum rank value.
    private int dfs(int curr, int parent, int rank, int[] steps, List<List<Integer>> graph, List<List<Integer>> res) {
        steps[curr] = rank + 1;
        for(int neighbor : graph.get(curr)) {
            if(neighbor == parent) continue;
            if(steps[neighbor] == -1) {
                steps[curr] = Math.min(steps[curr], dfs(neighbor, curr, rank + 1, steps, graph, res));
            } else {
                steps[curr] = Math.min(steps[curr], steps[neighbor]);
            }
        }
        if(steps[curr] == rank + 1 && curr != 0) res.add(Arrays.asList(curr, parent));
        return steps[curr];
    }
}
