package LeetCode.LC_1_200.LC112;

import Shared.TreeNode;
import java.util.ArrayDeque;

/**
 * Solution 2: iterative DFS.
 */
public class Solution_2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        ArrayDeque<TreeNode> stack = new ArrayDeque();
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

