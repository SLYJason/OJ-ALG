package LeetCode.LC_201_400.LC236;

import Shared.TreeNode;

/**
 * Solution: recursion.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root; // LCA found.
        if(left == null && right == null) return null; // Both p and q not found.
        if(left == null) {
            return right; // one of p or q found.
        }
        return left; // one of p or q found.
    }
}
