package LeetCode.LC_1_200.LC106;

import Shared.TreeNode;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    int[] inorder;
    int[] postorder;
    int post_idx; // index of postorder to traverse from the end.
    Map<Integer, Integer> inorder_index = new HashMap(); // K: TreeNode value, V: value index of inorder.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length-1;
        for(int i=0; i<inorder.length; i++) {
            inorder_index.put(inorder[i], i);
        }
        return buildTree(0, postorder.length-1);
    }

    private TreeNode buildTree(int left, int right) {
        if(left > right) return null;

        int root_val = postorder[post_idx];
        int in_idx = inorder_index.get(root_val); // root element split inorder into left and right subtree.
        post_idx--;

        TreeNode root = new TreeNode(root_val);
        root.right = buildTree(in_idx+1, right);
        root.left = buildTree(left, in_idx-1);
        return root;
    }
}
