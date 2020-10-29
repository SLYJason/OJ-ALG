package LeetCode.LC_1_200.LC114;

import Shared.TreeNode;
import java.util.ArrayDeque;

/**
 * Solution: using PreOrder iterative traversal.
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode dummy = new TreeNode();
        dummy.right = root;
        TreeNode prev = dummy;

        ArrayDeque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            prev.right = cur;
            prev.left = null;
            prev = cur;

            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
    }
}
