package LeetCode.LC_1_200.LC101;

import Shared.TreeNode;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode rootA, TreeNode rootB) {
        if(rootA == null && rootB == null) return true;
        if(rootA == null || rootB == null) return false;
        return rootA.val == rootB.val
                && isSymmetric(rootA.left, rootB.right)
                && isSymmetric(rootA.right, rootB.left);
    }
}
