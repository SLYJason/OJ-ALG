package LeetCode.LC_1_200.LC114;

import Shared.TreeNode;
import java.util.ArrayDeque;

/**
 * Solution: preorder + iterative.
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        ArrayDeque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        TreeNode prev = new TreeNode();
        prev.right = root;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            prev.left = null;
            prev.right = cur;
            prev = cur;
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
    }
}
