package LeetCode;

import java.util.Stack;

// iterative solution
public class LeetCode112_Sol2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            if(currNode.left == null && currNode.right == null && currNode.val == sum) {
                return true;
            }
            if(currNode.right != null) {
                currNode.right.val += currNode.val;
                stack.push(currNode.right);
            }
            if(currNode.left != null) {
                currNode.left.val += currNode.val;
                stack.push(currNode.left);
            }
        }
        return false;
    }
}

