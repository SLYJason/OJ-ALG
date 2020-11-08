package LeetCode.LC_1_200.LC104;

import Shared.TreeNode;

/**
 * Solution 2: DFS, bottom-up.
 */
public class Solution_2 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
