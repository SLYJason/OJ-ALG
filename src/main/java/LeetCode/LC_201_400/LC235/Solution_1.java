package LeetCode.LC_201_400.LC235;

import Shared.TreeNode;

/**
 * Solution: recursive.
 */
public class Solution_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && q.val >= root.val || q.val <= root.val && p.val >= root.val) return root;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
