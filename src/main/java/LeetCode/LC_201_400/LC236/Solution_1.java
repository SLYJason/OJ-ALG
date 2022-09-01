package LeetCode.LC_201_400.LC236;

import Shared.TreeNode;

/**
 * Solution 1: recursive.
 */
public class Solution_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root; // LCA found.
        if (left == null && right == null) return null; // Both p and q not found.
        return left != null ? left : right; // either p or q found.
    }
}
