package LeetCode.Tree;

import Shared.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode226 {
    // Solution 1: DFS recursive
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // Solution 1: DFS iterative
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if(left != null) stack.push(left);
            if(right != null) stack.push(right);
        }
        return root;
    }
}
