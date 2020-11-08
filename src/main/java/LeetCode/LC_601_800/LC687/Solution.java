package LeetCode.LC_601_800.LC687;

import Shared.TreeNode;

public class Solution {
    int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        unival_path(root);
        return longest;
    }

    private int unival_path(TreeNode root) {
        if(root == null) return 0;
        int left = unival_path(root.left);
        int right = unival_path(root.right);
        int left_path = 0, right_path = 0;
        if(root.left != null && root.left.val == root.val) {
            left_path = left + 1;
        }
        if(root.right != null && root.right.val == root.val) {
            right_path = right + 1;
        }
        longest = Math.max(longest, left_path + right_path);
        return Math.max(left_path, right_path);
    }
}
