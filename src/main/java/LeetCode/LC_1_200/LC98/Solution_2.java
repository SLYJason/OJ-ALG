package LeetCode.LC_1_200.LC98;

import Shared.TreeNode;

/**
 * Solution 1: Optimization of Solution 1.
 */
public class Solution_2 {
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (prev != null && prev >= root.val) return false;
        prev = root.val;
        return isValidBST(root.right);
    }
}
