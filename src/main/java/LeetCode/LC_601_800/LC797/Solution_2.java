package LeetCode.LC_601_800.LC797;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

/**
 * Solution 1: BFS.
 */
public class Solution_2 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<List<Integer>> ans = new LinkedList();
        Queue<List<Integer>> queue = new LinkedList();
        queue.offer(Arrays.asList(0));
        while(!queue.isEmpty()) {
            List<Integer> currPath = queue.poll();
            int currNode = currPath.get(currPath.size() - 1);
            if(currNode == target) {
                ans.add(new LinkedList(currPath));
            }
            for(int node : graph[currNode]) {
                List<Integer> nextPath = new LinkedList(currPath);
                nextPath.add(node);
                queue.add(nextPath);
            }
        }
        return ans;
    }
}
