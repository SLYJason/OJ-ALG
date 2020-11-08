package LeetCode.LC_1_200.LC104;

import Shared.TreeNode;

/**
 * Solution 2: DFS, top-down.
 */
public class Solution_3 {
    int max_depth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max_depth;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            max_depth = Math.max(max_depth, depth);
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
