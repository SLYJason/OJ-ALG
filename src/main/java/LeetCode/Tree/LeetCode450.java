package LeetCode.Tree;

import Shared.TreeNode;

public class LeetCode450 {
    /**
     * There are 4 cases that the node contains the key may reside in the tree:
     * 1. node is a leaf.
     * 2. node is not leaf and only has left child.
     * 3. node is not leaf and only has right child.
     * 4. node is not leaf and has both left and right child.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null && root.right == null) {
                // node is a leaf
                root = null;
            } else if(root.right == null) {
                // node only has left child
                return root.left;
            } else if(root.left == null) {
                // node only has right child
                return root.right;
            } else {
                // node has both left and right child
                root.val = findMin(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    // Given a node, find minimum value in the right subtree
    private int findMin(TreeNode root) {
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
