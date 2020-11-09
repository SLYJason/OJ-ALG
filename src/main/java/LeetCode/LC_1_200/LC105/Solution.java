package LeetCode.LC_1_200.LC105;

import Shared.TreeNode;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: using LC106 logic, i.e. using HashMap.
 */
public class Solution {
    int[] preorder;
    int[] inorder;
    int pre_idx; // index of preorder to traverse from the start.
    Map<Integer, Integer> inorder_index = new HashMap(); // K: TreeNode value, V: value index of inorder.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        pre_idx = 0;
        for(int i=0; i<inorder.length; i++) {
            inorder_index.put(inorder[i], i);
        }
        return buildTree(0, preorder.length-1);
    }

    private TreeNode buildTree(int left, int right) {
        if(left > right) return null;

        int val = preorder[pre_idx];
        pre_idx++;
        int in_idx = inorder_index.get(val); // root element split inorder into left and right subtree.

        TreeNode root = new TreeNode(val);
        root.left = buildTree(left, in_idx-1);
        root.right = buildTree(in_idx+1, right);
        return root;
    }
}
