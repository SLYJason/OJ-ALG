package LeetCode.Tree;

import Shared.TreeNode;

public class LeetCode124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        ans = Math.max(ans, node.val+left+right);
        return Math.max(left, right) + node.val;
    }
}
