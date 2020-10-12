package LeetCode.LC_1001_1200.LC1120;

import Shared.TreeNode;

/**
 * Solution 2: optimal solution. Calculate the average from bottom to up.
 */
public class Solution_2 {
    double max = 0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode node) {
        if(node == null) return new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        double average = sum * 1.0 / count;
        max = Math.max(max, average);
        return new int[]{sum, count};
    }
}
