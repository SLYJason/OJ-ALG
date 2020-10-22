package LeetCode.LC_401_600.LC545;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    List<Integer> res = new ArrayList();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return res;
        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return res;
    }

    private void leftBoundary(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        res.add(root.val);
        if(root.left == null) {
            leftBoundary(root.right);
        } else {
            leftBoundary(root.left);
        }
    }

    private void rightBoundary(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        if(root.right == null) {
            rightBoundary(root.left);
        } else {
            rightBoundary(root.right);
        }
        res.add(root.val);
    }

    private void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}
