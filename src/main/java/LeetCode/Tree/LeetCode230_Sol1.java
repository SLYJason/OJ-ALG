package LeetCode.Tree;

import java.util.List;
import java.util.ArrayList;
import Shared.TreeNode;

public class LeetCode230_Sol1 {
    // Solution 1: recursive
    List<Integer> list = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        System.out.println(list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}
