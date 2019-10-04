package LeetCode;

import java.util.Stack;

public class LeetCode938 {

    // Recursive solution
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    private void dfs(TreeNode node, int L, int R) {
        if (node == null) return;
        if (node.val >= L && node.val <= R) {
            sum += node.val;
            dfs(node.right, L, R);
            dfs(node.left, L, R);
        }
        if (node.val < L) {
            dfs(node.right, L, R);
        }
        if (node.val > R) {
            dfs(node.left, L, R);
        }
    }

    // Iterative solution
    /*public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (node.val >= L && node.val <= R) {
                sum += node.val;
                stack.push(node.left);
                stack.push(node.right);
            }
            if (node.val < L) stack.push(node.right);
            if (node.val > R) stack.push(node.left);
        }
        return sum;
    }*/
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

