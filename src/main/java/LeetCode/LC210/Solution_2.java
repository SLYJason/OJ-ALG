package LeetCode.LC210;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution: DFS.
 */
public class Solution_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList();
        for(int i=0; i<numCourses; i++) graph.add(new ArrayList());
        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 0: unvisited, 1: visiting, 2: visited.
        int[] states = new int[numCourses];
        List<Integer> res = new ArrayList();
        for(int i=0; i<numCourses; i++) {
            if(hasCyclic(i, states, graph, res)) return new int[0];
        }
        // building the result.
        int[] ans = new int[res.size()];
        for(int i=0; i<ans.length; i++) {
            ans[i] = res.get(res.size()-i-1);
        }
        return ans;
    }

    private boolean hasCyclic(int curr, int[] states, List<List<Integer>> graph, List<Integer> res) {
        if(states[curr] == 1) return true;
        if(states[curr] == 2) return false;
        states[curr] = 1;

        for(int neighbor : graph.get(curr)) {
            if(hasCyclic(neighbor, states, graph, res)) return true;
        }
        states[curr] = 2;
        res.add(curr);
        return false;
    }
}
