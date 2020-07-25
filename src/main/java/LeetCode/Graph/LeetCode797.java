package LeetCode.Graph;

import java.util.List;
import java.util.LinkedList;

public class LeetCode797 {
    int[][] grapth;
    int target;
    List<List<Integer>> ans;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.grapth = graph;
        this.target = graph.length-1;
        this.ans = new LinkedList();
        LinkedList<Integer> path = new LinkedList();
        path.add(0);
        dfs(0, path);
        return ans;
    }

    private void dfs(int currNode, LinkedList<Integer> path) {
        if(currNode == target) {
            // Important: should make a deep copy of the path
            ans.add(new LinkedList<Integer>(path));
            return;
        }
        for(int next : grapth[currNode]) {
            path.add(next);
            dfs(next, path);
            // backtracking: choose the previous choice, remove the last node
            path.removeLast();
        }
    }
}
