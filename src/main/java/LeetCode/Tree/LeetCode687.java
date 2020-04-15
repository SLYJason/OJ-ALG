package LeetCode.Tree;

import Shared.TreeNode;

// Time Complexity: O(N)
// Space Complexity: O(N)
public class LeetCode687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int pathLeft = 0, pathRight = 0;
        if(node.left != null && node.val == node.left.val) {
            pathLeft = left + 1;
        }
        if(node.right != null && node.val == node.right.val) {
            pathRight = right + 1;
        }
        max = Math.max(max, pathLeft + pathRight);
        return Math.max(pathLeft, pathRight);
    }
}
