package LeetCode.LC_401_600.LC450;

import java.util.List;
import java.util.ArrayList;
import Shared.TreeNode;

/**
 * Solution: brute force - NOT recommended.
 */
public class Solution_1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list, key);
        // System.out.println(list);
        return buildBST(list, 0, list.size() - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list, int key) {
        if (node == null) return;
        inOrderTraversal(node.left, list, key);
        if (node.val != key) {
            list.add(node.val);
        }
        inOrderTraversal(node.right, list, key);
    }

    private TreeNode buildBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBST(list, start, mid - 1);
        node.right = buildBST(list, mid + 1, end);
        return node;
    }
}
