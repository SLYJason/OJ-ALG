package LeetCode.LC_201_400.LC285;

import Shared.TreeNode;

/**
 * Follow Up.
 */
public class FollowUp {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;
        while (root != null) {
            if (root.val <= p.val) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }
}
