package LeetCode.LC_1_200.LC110;

import Shared.TreeNode;

/**
 * Solution 2: bottom-up recursion.
 */
public class Solution_2 {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = 1 + getDepth(root.left);
        int right = 1 + getDepth(root.right);
        if(Math.abs(left - right) > 1) isBalanced = false;
        return Math.max(left, right);
    }
}
