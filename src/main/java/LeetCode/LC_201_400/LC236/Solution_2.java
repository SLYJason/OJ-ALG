package LeetCode.LC_201_400.LC236;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import Shared.TreeNode;

/**
 * Solution 2: iterative.
 */
public class Solution_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>(); // key: root node, child: left or right child node.
        parent.put(root, null);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        // step 1: build parent, find p and q.
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        // step 2: find all ancestors of node p, the LCA must exist in one of these ancestors.
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        // step 3: go through all the ancestors of node q, if the ancestors of node p contains any ancestor of q, then the LCA found.
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
