package LeetCode.Tree;

import Shared.TreeNode;

public class LeetCode701 {
    /**
     * Solution 1: recursion
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    /**
     * Solution 1: iteration
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode node = root;
        while(node != null) {
            if(val > node.val) {
                if(node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            } else {
                if(node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            }
        }
        return root;
    }
}
