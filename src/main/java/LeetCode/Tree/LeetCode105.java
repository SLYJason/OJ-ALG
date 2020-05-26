package LeetCode.Tree;

import Shared.TreeNode;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length-1, preorder, inorder);
    }

    private TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length-1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = 0;
        for(int i=0; i<inorder.length; i++) {
            if(root.val == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        root.left = build(preStart+1, inStart, rootIndex-1, preorder, inorder);
        root.right = build(preStart+1+rootIndex-inStart, rootIndex+1, inEnd, preorder, inorder);
        return root;
    }
}
