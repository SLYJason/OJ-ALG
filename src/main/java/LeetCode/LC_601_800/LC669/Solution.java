package LeetCode.LC_601_800.LC669;

import Shared.TreeNode;

/**
 * Solution: recursion.
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val >= low && root.val <= high) {
            // trim left & right
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } else if(root.val < low) {
            // trim right
            return trimBST(root.right, low, high);
        } else {
            // trim left
            return trimBST(root.left, low, high);
        }
        return root;
    }
}
