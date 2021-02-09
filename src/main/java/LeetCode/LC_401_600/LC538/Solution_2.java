package LeetCode.LC_401_600.LC538;

import java.util.ArrayDeque;
import Shared.TreeNode;

/**
 * Solution 2: iteration.
 */
public class Solution_2 {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        int sum = 0;
        TreeNode cur = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
