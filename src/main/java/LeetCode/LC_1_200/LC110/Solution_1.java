package LeetCode.LC_1_200.LC110;

import Shared.TreeNode;

/**
 * Solution 1: top-down recursion.
 */
public class Solution_1 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = 1 + getDepth(root.left);
        int right = 1 + getDepth(root.right);
        return Math.max(left, right);
    }
}
