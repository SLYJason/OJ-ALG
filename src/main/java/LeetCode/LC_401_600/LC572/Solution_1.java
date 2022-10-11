package LeetCode.LC_401_600.LC572;

import java.util.ArrayDeque;
import Shared.TreeNode;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isEqual(node, subRoot)) return true;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return false;
    }

    private boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }
}
