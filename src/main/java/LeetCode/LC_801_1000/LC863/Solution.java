package LeetCode.LC_801_1000.LC863;

import Shared.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution: DFS + BFS.
 * Time Complexity: O(N), BFS always take O(m + n), n is # of nodes and m is # of edges. In the tree, m = n-1, so O(m+n) = O(n-1+n) = O(n) = o(N).
 * Space Complexity: O(N).
 */
public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root == null) return new ArrayList();
        if(K == 0) return Arrays.asList(target.val); // corner case.
        List<Integer> res = new ArrayList();
        Map<TreeNode, List<TreeNode>> graph = new HashMap();
        buildGraph(root, null, graph);
        //BFS: find the values.
        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> visited = new HashSet();
        visited.add(target);
        queue.offer(target);
        while(K >= 0) {
            K--;
            for(int i=queue.size(); i>0; i--) {
                TreeNode parent = queue.poll();
                for(TreeNode neighbor : graph.get(parent)) {
                    if(!visited.contains(neighbor)) {
                        if(K == 0) res.add(neighbor.val);
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }

    // DFS: build a undirected graph.
    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        graph.put(node, new ArrayList());
        if(parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        if(node.left != null) buildGraph(node.left, node, graph);
        if(node.right != null) buildGraph(node.right, node, graph);
    }
}
