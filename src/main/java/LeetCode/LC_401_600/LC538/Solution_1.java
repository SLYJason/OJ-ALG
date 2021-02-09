package LeetCode.LC_401_600.LC538;

import Shared.TreeNode;

/**
 * Solution 1: recursion.
 */
public class Solution_1 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
