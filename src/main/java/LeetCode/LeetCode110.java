package LeetCode;

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(getDepth(root.left, 0) - getDepth(root.right, 0)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int getDepth(TreeNode root, int currDepth) {
        if(root == null) return currDepth;
        currDepth++;
        if(root.left == null && root.right == null) return currDepth;
        return Math.max(getDepth(root.left, currDepth), getDepth(root.right, currDepth));
    }
}
