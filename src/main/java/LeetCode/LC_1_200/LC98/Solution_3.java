package LeetCode.LC_1_200.LC98;

import Shared.TreeNode;

/**
 * Solution 3: Recursive with Valid Range.
 */
public class Solution_3 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer upperBound, Integer lowerBound) {
        if (node == null) return true;
        if (upperBound != null && node.val >= upperBound || lowerBound != null && node.val <= lowerBound) return false;
        return dfs(node.left, node.val, lowerBound) && dfs(node.right, upperBound, node.val);
    }
}
