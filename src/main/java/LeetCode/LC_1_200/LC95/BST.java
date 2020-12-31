package LeetCode.LC_1_200.LC95;

import Shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BST {
    private TreeNode buildBST(int[] arr) {
        return build(0, arr.length-1, arr);
    }

    private TreeNode build(int left, int right, int[] arr) {
        if(left > right) return null;
        int mid = left + (right - left) / 2; // use mid as root, we can have a balanced BST.

        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(left, mid-1, arr);
        root.right = build(mid+1, right, arr);
        return root;
    }

    private static void inOrder(List<Integer> list, TreeNode root) {
        if(root == null) return;
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        // build BST.
        BST bst = new BST();
        TreeNode root = bst.buildBST(arr);
        // in order traversal BST to validate.
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        System.out.println(list);
    }
}
