package LeetCode.Tree;

import java.util.List;
import java.util.LinkedList;
import Shared.TreeNode;

/**
 * Solution 1: brute force, using BST features.
 */
public class LeetCode98_Sol1 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> list = new LinkedList();
        inOrder(root, list);
        for(int i=1; i<list.size(); i++) {
            if(list.get(i) <= list.get(i-1)) return false;
        }
        return true;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}