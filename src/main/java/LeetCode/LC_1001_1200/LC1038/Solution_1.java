package LeetCode.LC_1001_1200.LC1038;

import Shared.TreeNode;

/**
 * Solution 1: recursion.
 */
public class Solution_1 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}
