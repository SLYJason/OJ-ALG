package LeetCode.LC_201_400.LC285;

import Shared.TreeNode;

/**
 * Solution: iterative.
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null) {
            if(root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
}
