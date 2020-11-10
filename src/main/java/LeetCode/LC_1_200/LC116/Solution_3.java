package LeetCode.LC_1_200.LC116;

/**
 * Solution 3: optimized DFS.
 */
public class Solution_3 {
    public Node connect(Node root) {
        if(root == null) return null;
        preOrder(root);
        return root;
    }

    private void preOrder(Node root) {
        if(root.left == null && root.right == null) return;
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        preOrder(root.left);
        preOrder(root.right);
    }
}
