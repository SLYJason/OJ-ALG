package LeetCode.LC_1_200.LC98;

import Shared.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Solution 1: Brute Force InOrder.
 */
public class Solution_1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
}
