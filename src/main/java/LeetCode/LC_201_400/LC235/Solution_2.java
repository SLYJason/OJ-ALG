package LeetCode.LC_201_400.LC235;

import Shared.TreeNode;

/**
 * Solution: iterative.
 */
public class Solution_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode parent = root;
        while (parent != null) {
            if (p.val <= parent.val && q.val <= parent.val) {
                parent = parent.left;
            } else if (p.val > parent.val && q.val > parent.val) {
                parent = parent.right;
            } else {
                return parent;
            }
        }
        return null;
    }
}
