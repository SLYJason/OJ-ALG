package LeetCode.Tree;

import Shared.TreeNode;

import java.util.Stack;

public class LeetCode100 {
    /**
     * Solution 1: DFS recursive
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Solution 2: DFS iterative
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Stack<TreeNode> stack = new Stack();
        stack.push(p);
        stack.push(q);
        while(!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if(n1 == null && n2 == null) {
                continue;
            } else if (n1 == null || n2 == null) {
                return false;
            } else if (n1.val != n2.val) {
                return false;
            } else {
                stack.push(n1.right);
                stack.push(n2.right);
                stack.push(n1.left);
                stack.push(n2.left);
            }
        }
        return true;
    }
}
