package LeetCode.LC_1001_1200.LC1120;

import Shared.TreeNode;
import java.util.ArrayDeque;

/**
 * Solution 1: brute force, intuitive thoughts. Calculate the average from up to bottom.
 */
public class Solution_1 {
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return 0;
        double max = Integer.MIN_VALUE;
        ArrayDeque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int[] arr = new int[2]; // arr[0] subtree sum, arr[1] # of subtree nodes.
            sum(node, arr);
            double average = arr[0] * 1.0 / arr[1];
            max = Math.max(max, average);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return max;
    }

    private void sum(TreeNode root, int[] arr) {
        if(root == null) return;
        arr[0] += root.val;
        arr[1] += 1;
        sum(root.left, arr);
        sum(root.right, arr);
    }
}
