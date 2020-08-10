package LeetCode.Tree;

import Shared.TreeNode;

/**
 * Solution 2: iterative
 */
public class LeetCode270_Sol2 {
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        int closet = root.val;
        while(root != null) {
            closet = Math.abs(closet - target) < Math.abs(root.val - target) ? closet : root.val;
            root = root.val > target ? root.left : root.right;
        }
        return closet;
    }
}
