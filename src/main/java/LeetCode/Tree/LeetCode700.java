package LeetCode.Tree;

import Shared.TreeNode;

public class LeetCode700 {
    // Solution 1: recursion
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }

    // Solution 2: iteration
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null && root.val != val) {
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }
}
