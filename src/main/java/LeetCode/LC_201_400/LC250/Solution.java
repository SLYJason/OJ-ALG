package LeetCode.LC_201_400.LC250;

import Shared.TreeNode;

public class Solution {
    int unival_count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        unival(root);
        return unival_count;
    }

    private boolean unival(TreeNode root) {
        if(root == null) return true;
        boolean left = unival(root.left);
        boolean right = unival(root.right);
        if(left && right
                && (root.left == null || root.left.val == root.val)
                && (root.right == null || root.right.val == root.val)) {
            unival_count++;
            return true;
        }
        return false;
    }
}
