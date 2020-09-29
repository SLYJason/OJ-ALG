package LeetCode.LC207;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution: DFS.
 */
public class Solution_2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList();
        for(int i=0; i<numCourses; i++) graph.add(new ArrayList());
        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 0: unvisited, 1: visiting, 2: visited.
        int[] states = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(hasCyclic(i, states, graph)) return false;
        }
        return true;
    }

    private boolean hasCyclic(int curr, int[] states, List<List<Integer>> graph) {
        if(states[curr] == 1) return true;
        if(states[curr] == 2) return false;
        states[curr] = 1;
        for(int neighbor : graph.get(curr)) {
            if(hasCyclic(neighbor, states, graph)) return true;
        }
        states[curr] = 2;
        return false;
    }
}
