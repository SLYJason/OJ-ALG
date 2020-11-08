package LeetCode.LC_1_200.LC112;

import Shared.TreeNode;

/**
 * Solution 1: recursive DFS.
 */
public class Solution_1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right ==null) return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
