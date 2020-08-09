package LeetCode.Tree;

import Shared.TreeNode;

public class LeetCode270 {
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        return dfs(root, target, root.val);
    }

    private int dfs(TreeNode node, double target, int closet) {
        if(node == null) return closet;
        if(Math.abs(target - node.val) < Math.abs(target - closet)) {
            closet = node.val;
        }
        return node.val > target ? dfs(node.left, target, closet) : dfs(node.right, target, closet);
    }
}
